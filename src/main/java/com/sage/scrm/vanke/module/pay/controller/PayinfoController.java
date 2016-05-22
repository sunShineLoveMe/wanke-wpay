package com.sage.scrm.vanke.module.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sage.scrm.vanke.module.pay.model.Payinfo;
import com.sage.scrm.vanke.module.pay.service.PayinfoService;

/**
 * ClassName: PayinfoController <br/>
 * date: 2015-8-24 下午4:54:09 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
@Controller
@RequestMapping("/payinfoController")
public class PayinfoController {
	
	
	private PayinfoService payinfoService;
	
	
	
	@RequestMapping(value = "/queryIsCollect")
	@ResponseBody
	public Map<String, Object> pay(HttpServletRequest request,String params){
		Map<String, Object> map = null;
		String isCollect = "0";
		String memberId = "";
		try {
			map = new HashMap<String, Object>();
			isCollect = payinfoService.queryIsCollect(memberId);
			
			map.put("isCollect", isCollect);
			map.put("admin", "admin");
			map.put("code", "200");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Autowired
	public void setPayinfoService(PayinfoService payinfoService) {
		this.payinfoService = payinfoService;
	}
	

}
