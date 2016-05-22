package com.sage.scrm.vanke.module.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sage.scrm.vanke.module.pay.model.Actitypayconfig;
import com.sage.scrm.vanke.module.pay.service.ActitypayconfigService;

/**
 * ClassName: PayinfoController <br/>
 * date: 2015-8-24 下午4:54:09 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
@Controller
@RequestMapping("/actitypayconfigController")
public class ActitypayconfigController {
	
	private ActitypayconfigService actitypayconfigService;
	private static String SUCCESS ="200";
	
	@RequestMapping(value = "/queryByStatus")
	@ResponseBody
	public Map<String,Object> queryByStatus(HttpServletRequest request,String params){
		Map<String,Object> map = null;
		List<Actitypayconfig> list = null;
		try {
			map = new HashMap<String, Object>();
			list = actitypayconfigService.queryByStatus("1");
			map.put("code", SUCCESS);
			map.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}



	@Autowired
	public void setActitypayconfigService(ActitypayconfigService actitypayconfigService) {
		this.actitypayconfigService = actitypayconfigService;
	}

	
	

}
