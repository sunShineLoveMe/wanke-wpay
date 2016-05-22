package com.sage.scrm.vanke.module.pay.utils;

import com.sage.scrm.core.utils.ThreadLocalUtil;


public class ApiParams {

    /**
     * 
     * getExtSystemId:(获取当前调用请求的系统Id). <br/>
     *
     * @author zhouy
     * @return
     * @since JDK 1.6
     */
    public static Long getExtSystemId() {
        return (ThreadLocalUtil.get(ThreadLocalUtil.SYSTEM_ID) == null) ? null : Long.valueOf(ThreadLocalUtil.get(ThreadLocalUtil.SYSTEM_ID).toString());
    }
    
    /**
     * 
     * getProductStoreId:(获取门店Id). <br/>
     *
     * @author zhouy
     * @return
     * @since JDK 1.6
     */
    public static Long getProductStoreId() {
        return (ThreadLocalUtil.get(ThreadLocalUtil.PRODUCT_STORE_ID) == null) ? null : Long.valueOf(ThreadLocalUtil.get(ThreadLocalUtil.PRODUCT_STORE_ID).toString());
    }
    
    /**
     * 
     * getMsgId:(获取消息Id). <br/>
     *
     * @author zhouy
     * @return
     * @since JDK 1.6
     */
    public static String getMsgId() {
        return (ThreadLocalUtil.get(ThreadLocalUtil.MSG_ID) == null) ? null : ThreadLocalUtil.get(ThreadLocalUtil.MSG_ID).toString();
    }
    
    /**
     * 
     * getChannelId:(获取渠道Id). <br/>
     *
     * @author zhouy
     * @return
     * @since JDK 1.6
     */
    public static Long getChannelId() {
        return (ThreadLocalUtil.get(ThreadLocalUtil.CHANNEL_ID) == null) ? null : Long.valueOf(ThreadLocalUtil.get(ThreadLocalUtil.CHANNEL_ID).toString());
    }
    
    /**
     * getIp:(获取Ip). <br/>
     * Date: 2016-5-12 下午3:41:14 <br/>
     * scrmVersion 1.0
     * @author mennan
     * @version jdk1.7
     * @return
     */
   /* public static String getIp() {
    	return (ThreadLocalUtil.get(ThreadLocalUtil.CXF_REQUEST_IP) == null) ? null : ThreadLocalUtil.get(ThreadLocalUtil.CXF_REQUEST_IP).toString();
    }*/
    
}
