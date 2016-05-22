/**
 * Copyright (C), 2010-2015, 赛捷软件（上海有限公司）.
 * Project Name:scrm-service-main
 * File Name:ActivityService.java
 * Package Name:com.sage.scrm.service.activity.service.impl
 * Date:2015-8-11下午1:50:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
*/

package com.sage.scrm.vanke.module.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sage.scrm.core.mapper.BaseMapper;
import com.sage.scrm.core.repository.BaseRepository;
import com.sage.scrm.core.service.impl.BaseServiceImpl;
import com.sage.scrm.vanke.module.pay.model.Payinfo;
import com.sage.scrm.vanke.module.pay.repository.PayinfoRepository;
import com.sage.scrm.vanke.module.pay.service.PayinfoService;

/**
 * ClassName: ActivityServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015-8-27 下午3:17:07 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
@Service
public class PayinfoServiceImpl extends BaseServiceImpl<Payinfo> implements PayinfoService{

	private PayinfoRepository payinfoRepository;
	
	@Override
	public BaseRepository<Payinfo, ? extends BaseMapper<Payinfo>> getBaseRepository() {
		return payinfoRepository;
		
	}
	
	@Autowired
	public void setPayinfoRepository(PayinfoRepository payinfoRepository) {
		this.payinfoRepository = payinfoRepository;
	}

	@Override
	public List<Payinfo> queryAll() {
		return payinfoRepository.findAll();
	}

	@Override
	public String queryIsMember(String mobile) {
		return payinfoRepository.findIsMember(mobile);
	}

	@Override
	public String queryIsCollect(String memberId,String activityId) {
		return payinfoRepository.findIsCollect(memberId,activityId);
	}

	@Override
	public int queryIsPay(String memberId, String activityId) {
		return payinfoRepository.findIsPay(memberId,activityId);
	}

	
}

