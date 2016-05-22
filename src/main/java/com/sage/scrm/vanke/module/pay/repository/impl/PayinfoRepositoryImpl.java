/**
 * Copyright (C), 2010-2015, 赛捷软件（上海有限公司）.
 * Project Name:scrm-module-activity
 * File Name:ss.java
 * Package Name:com.sage.scrm.module.activity.repository.impl
 * Date:2015-8-11下午1:42:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
*/

package com.sage.scrm.vanke.module.pay.repository.impl;

import org.springframework.stereotype.Repository;

import com.sage.scrm.core.repository.impl.BaseRepositoryImpl;
import com.sage.scrm.vanke.module.pay.mapper.PayinfoMapper;
import com.sage.scrm.vanke.module.pay.model.Payinfo;
import com.sage.scrm.vanke.module.pay.repository.PayinfoRepository;

/**
 * ClassName:活动 <br/>
 * Date: 2015-8-11 下午1:42:05 <br/>
 * scrmVersion 1.0
 * @author   mennan
 * @version  jdk1.7
 * @see 	 
 */
@Repository
public class PayinfoRepositoryImpl extends BaseRepositoryImpl<Payinfo, PayinfoMapper> implements PayinfoRepository{

	@Override
	protected Class<PayinfoMapper> getMapperClass() {
		return PayinfoMapper.class;
	}

	@Override
	public String findIsMember(String mobile) {
		return this.getMapper().selectIsMember(mobile);
	}

	@Override
	public String findIsCollect(String memberId) {
		return this.getMapper().selectIsCollect(memberId);
	}

	@Override
	public int findIsPay(String memberId) {
		return this.getMapper().selectIsPay(memberId);
	}

	
}

