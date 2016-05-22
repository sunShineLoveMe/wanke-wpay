package com.sage.scrm.vanke.module.pay.utils;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "apiResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApiResult implements java.io.Serializable{

	private static final long serialVersionUID = -4341384120130276377L;
	
	//返回码
	private String code;
	//返回消息
	private String message;
	//主标识
//	private String identity;
	
	//主对象数据
	@XmlJavaTypeAdapter(MapAdapter.class)
	private Map<String, Object> data = new HashMap<String, Object>();
	
	//明细对象数据集
	@XmlJavaTypeAdapter(MapAdapter.class)
	private List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
	
	public void addItem(Map<String, Object> item){
		this.items.add(item);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public String getIdentity() {
//		return identity;
//	}
//
//	public void setIdentity(String identity) {
//		this.identity = identity;
//	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<Map<String, Object>> getItems() {
		return items;
	}

	public void setItems(List<Map<String, Object>> items) {
		this.items = items;
	}
	
}

