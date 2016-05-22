package com.sage.scrm.vanke.module.pay.utils;



import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: RequestUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015-8-19 上午10:52:42 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
public class RequestUtil {

	/**
	 * 
	 * getRemoteIpAddr:(获取客户端ip地址). <br/>

	 */
	public static String getRemoteIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
