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
import com.sage.scrm.vanke.module.pay.model.Actitypayconfig;
import com.sage.scrm.vanke.module.pay.repository.ActitypayconfigRepository;
import com.sage.scrm.vanke.module.pay.service.ActitypayconfigService;

/**
 * ClassName: ActivityServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015-8-27 下午3:17:07 <br/>
 * scrmVersion 1.0
 * @author mennan
 * @version jdk1.7
 */
@Service
public class ActitypayconfigServiceImpl extends BaseServiceImpl<Actitypayconfig> implements ActitypayconfigService{

	private ActitypayconfigRepository  actitypayconfigRepository;
	
	
	@Override
	public BaseRepository<Actitypayconfig, ? extends BaseMapper<Actitypayconfig>> getBaseRepository() {
		return actitypayconfigRepository;
	}
	
	
	@Override
	public List<Actitypayconfig> queryAll() {
		return actitypayconfigRepository.findAll();
	}
	
	
	@Autowired
	public void setActitypayconfigRepository(ActitypayconfigRepository actitypayconfigRepository) {
		this.actitypayconfigRepository = actitypayconfigRepository;
	}


	@Override
	public List<Actitypayconfig> queryByStatus(String status) {
		return actitypayconfigRepository.findByStatus(status);
	}

	

}

