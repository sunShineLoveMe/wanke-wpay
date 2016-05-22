package com.sage.scrm.vanke.module.pay.utils;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * ClassName: 初始化加载属性配置文件 类<br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015-8-17 下午6:17:35 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
public class PropertiesConfInit {
	 	private static final Logger logger = LoggerFactory.getLogger(PropertiesConfInit.class);
	    private static final ClassLoader classLoader = PropertiesConfInit.class.getClassLoader();
	    private static final Map<String, Map<String, String>> CONFIG_PROPERTIES = new HashMap<String, Map<String, String>>();
	    private Map<String, String> locations;
	    
	    public PropertiesConfInit(){
	        
	    }
	    
	    public PropertiesConfInit(Map<String, String> locations){
	        this.locations = locations;
	    }
	    
	    /**
	     * init:(初始化系统配置文件). <br/>
	     * Date: 2015-8-17 下午6:17:58 <br/>
	     * scrmVersion 1.0
	     * @author mennan
	     * @version jdk1.7
	     */
	    @PostConstruct
	    private void init(){
	        Properties properties = null;
	        Map<String, String> props = null;
	        for(Map.Entry<String, String> location : locations.entrySet()){
	        	props = new HashMap<String, String>();
	            properties = new Properties();
	            try {
	                properties.load(classLoader.getResourceAsStream(location.getValue()));
	                for(Map.Entry<Object, Object> prop : properties.entrySet()){
	                    props.put((String)prop.getKey(), (String)prop.getValue());
	                }
	                CONFIG_PROPERTIES.put(location.getKey(), props);
	            } catch (IOException e) {
	                logger.error("初始化Takeout 属性配置文件出错:" + e.getMessage());
	            }
	        }
	        logger.info("初始化属性文件完成......");
	    }
	    
	    /**
	     * getProperties:功能描述: 获取系统配置的属性文件 <br/>
	     * Date: 2015-8-17 下午6:18:14 <br/>
	     * scrmVersion 1.0
	     * @author mennan
	     * @version jdk1.7
	     * @param propsType
	     * @return
	     */
	    public static Map<String, String> getProperties(String propsType){
	        return Collections.unmodifiableMap(CONFIG_PROPERTIES.get(propsType));
	    }

	    /**
	     * 获取相关配置的值
	     * @param propName
	     * @return
	     */
	    public static String getString(String propsType, String propName){
	    	if(CONFIG_PROPERTIES.get(propsType) == null || CONFIG_PROPERTIES.get(propsType).get(propName) == null) {
	    		return null;
	    	}
	        return CONFIG_PROPERTIES.get(propsType).get(propName).trim();
	    }
	    
	    public static Long getLong(String propsType, String propName){
	    	String val = getString(propsType, propName);
	    	if(StringUtils.isNotBlank(val)){
	    		return Long.valueOf(val.trim());
	    	}
	    	return null;
	        
	    }
	    
	    public static Integer getInteger(String propsType, String propName){
	    	String val = getString(propsType, propName);
	    	if(StringUtils.isNotBlank(val)){
	    		return Integer.valueOf(val.trim());
	    	}
	    	return null;
	    }
	    
	    public static Double getDouble(String propsType, String propName){
	    	String val = getString(propsType, propName);
	    	if(StringUtils.isNotBlank(val)){
	    		return Double.valueOf(val.trim());
	    	}
	    	return null;
	    }
	   
}
