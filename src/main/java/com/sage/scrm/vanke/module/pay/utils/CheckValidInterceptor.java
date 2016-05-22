package com.sage.scrm.vanke.module.pay.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import com.sage.scrm.core.utils.ThreadLocalUtil;

/**
 * ClassName: CheckValidInterceptor <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015-8-19 上午10:52:01 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
public class CheckValidInterceptor extends AbstractPhaseInterceptor<Message> {
	private static final String WEBSERVICE_CLIENT_IPS = PropertiesConfInit.getString("webConfig", "webservice_client_ips");
	private static final String WEBSERVICE_CLIENT_FILTER = PropertiesConfInit.getString("webConfig", "webservice_client_filter");
	private static final String IS_CHECK_SIGN = PropertiesConfInit.getString("signKey", "is_check_sign");
	private static final String CHECK_KEY_NAME = PropertiesConfInit.getString("signKey", "check_sign");
	private static final String SIGN_KEY = PropertiesConfInit.getString("signKey", "sign_key");
	private Logger logger = Logger.getLogger("CheckValidInterceptor");
	private static final List<String> IGNORE_CHECK_URLS = new ArrayList<String>();
	private static final List<String> CHECK_URLS = new ArrayList<String>();
	
	static {
		IGNORE_CHECK_URLS.add("rs/external/api/member/laveCouponCount");
		CHECK_URLS.add("/scrm-bk-job/rs/external/api/wechat/getAccessToken");
		CHECK_URLS.add("/scrm-bk-web/rs/external/api/member/WeChatFocusEvent");
	}

	public CheckValidInterceptor() {
		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		Map<String, List<String>> headerMap = null;
		List<String> sa = null;
		List<String> langx = null;
		List<String> org = null;
		List<String> store = null;
		List<String> msg = null;
		List<String> channel = null;
		String uncheckedKey = null;
		HttpServletRequest request = null;
		String clientIp = null;
		
		request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		
		clientIp = RequestUtil.getRemoteIpAddr(request);
		/*ThreadLocalUtil.set(ThreadLocalUtil.CXF_REQUEST_IP, clientIp);*/
		
		//TODO 如果key==N 并且url不在checkUrl中
		//是否不校验key
		if(StringUtils.isNotBlank(IS_CHECK_SIGN) && IS_CHECK_SIGN.equals("N") && !CHECK_URLS.contains(request.getRequestURI().toString())){
			return;
		}
		
		if("Y".equals(WEBSERVICE_CLIENT_FILTER) && !checkClientIps(request)){
			throw new Fault("非法客户端调用", logger);
		}
		boolean isNeedCheck = true;
		for (String url : IGNORE_CHECK_URLS) {
			if(request.getRequestURL().toString().contains(url)) {
				isNeedCheck = false;
				break;
			}
		}
		if(isNeedCheck) {
			headerMap = CastUtils.cast((Map<?, ?>) message.get(Message.PROTOCOL_HEADERS));
			
			// 取得header中的校验字符串
			if (headerMap != null) {
				System.out.println(headerMap.toString());
				sa = headerMap.get(CHECK_KEY_NAME);
				langx = headerMap.get(ThreadLocalUtil.LANGX);
				org = headerMap.get(ThreadLocalUtil.SYSTEM_ID);
				store = headerMap.get(ThreadLocalUtil.PRODUCT_STORE_ID);
				msg = headerMap.get(ThreadLocalUtil.MSG_ID);
				channel = headerMap.get(ThreadLocalUtil.CHANNEL_ID);
				if (sa != null && sa.size() > 0) {
					uncheckedKey = sa.get(0);
					if (StringUtils.isBlank(uncheckedKey)){
						throw new Fault("密钥为空", logger);
					}else{
						
					}
				} else {
					throw new Fault("无密钥", logger);
				}
				if(org != null && org.size() > 0) {
					ThreadLocalUtil.set(ThreadLocalUtil.SYSTEM_ID, org.get(0));
				}
				if(store != null && store.size() > 0) {
					ThreadLocalUtil.set(ThreadLocalUtil.PRODUCT_STORE_ID, store.get(0));
				}
				if(msg != null && msg.size() > 0) {
					ThreadLocalUtil.set(ThreadLocalUtil.MSG_ID, msg.get(0));
				}
				if(channel != null && channel.size() > 0) {
					ThreadLocalUtil.set(ThreadLocalUtil.CHANNEL_ID, channel.get(0));
				}
				if(langx != null && langx.size() > 0){
					ThreadLocalUtil.set(ThreadLocalUtil.LANGX, langx.get(0));
				}else{
					ThreadLocalUtil.set(ThreadLocalUtil.LANGX, "cn");
				}
			} else {
				throw new Fault("无header信息", logger);
			}
			
			List<?> tmpList = message.getContent(List.class);
			if(!uncheckedKey.equals(SIGN_KEY)){
				throw new Fault("验证错误", logger);
			}
			message.setContent(List.class, tmpList);
		}
	}

	/**
	 * checkClientIps:(检查客户端是否为合法调用ip). <br/>
	 * Date: 2015-8-19 上午10:53:26 <br/>
	 * scrmVersion 1.0
	 * @author mennan
	 * @version jdk1.7
	 * @param request
	 * @return
	 */
	private boolean checkClientIps(HttpServletRequest request){
		String clientIp = RequestUtil.getRemoteIpAddr(request);
		if(WEBSERVICE_CLIENT_IPS.contains(clientIp)){
			return true;
		}
		return false;
	}
}
