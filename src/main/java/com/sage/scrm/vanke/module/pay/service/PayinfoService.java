/**
 * Copyright (C), 2010-2015, 赛捷软件（上海有限公司）.
 * Project Name:scrm-service-main
 * File Name:ActivityService.java
 * Package Name:com.sage.scrm.service.activity.service.impl
 * Date:2015-8-11下午1:50:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
*/

package com.sage.scrm.vanke.module.pay.service;

import java.util.List;

import com.sage.scrm.core.service.BaseService;
import com.sage.scrm.vanke.module.pay.model.Payinfo;

/**
 * ClassName:ActivityService <br/>
 * Date: 2015-8-11 下午1:50:36 <br/>
 * scrmVersion 1.0
 * @author   mennan
 * @version  jdk1.7
 * @see 	 
 */
public interface PayinfoService extends BaseService<Payinfo>{

	List<Payinfo> queryAll();
	
	String queryIsMember(String mobile);
	
	String queryIsCollect(String memberId);
	
	String queryIsCollect(String memberId,String activityId);
	
	int queryIsPay(String memberId);
	
	int queryIsPay(String memberId,String activityId);
	
	
}

