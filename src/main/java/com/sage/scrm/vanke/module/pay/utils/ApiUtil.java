package com.sage.scrm.vanke.module.pay.utils;




/**
 * ClassName: ApiUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015-11-9 上午11:17:58 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
public class ApiUtil {
	
	/**
	 * 修改返回信息
	 * 
	 * @param result
	 * @param error
	 * @return
	 */
	public static ApiResult getResult(ApiResult result, ResultStatus resultStatus) {
		result.setCode(resultStatus.getCode());
		result.setMessage(resultStatus.getMsg());
		return result;
	}
	
	/**
	 * 
	 * getExtSystemId:(获取当前调用请求的系统Id). <br/>
	 * @return
	 * @since JDK 1.6
	 */
	public static Long getExtSystemId() {
	    return ApiParams.getExtSystemId();
	}
	
	/**
	 * 
	 * getProductStoreId:(获取门店Id). <br/>
	 * @return
	 * @since JDK 1.6
	 */
	public static Long getProductStoreId() {
	    return ApiParams.getProductStoreId();
	}
	
	/**
	 * 
	 * getMsgId:(获取消息Id). <br/>
	 * @return
	 * @since JDK 1.6
	 */
	public static String getMsgId() {
	    return ApiParams.getMsgId();
	}
	
	/**
	 * getChannelId:(获取渠道Id). <br/>
	 * @return
	 * @since JDK 1.6
	 */
	public static Long getChannelId() {
	    return ApiParams.getChannelId();
	}
	
	/**
	 * getIp:(获取ip). <br/>
	 * Date: 2016-5-12 下午3:41:58 <br/>
	 * scrmVersion 1.0
	 * @author mennan
	 * @version jdk1.7
	 * @return
	 */
	/*public static String getIp() {
		return ApiParams.getIp();
	}*/
	
	
}

