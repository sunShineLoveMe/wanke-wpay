/**
 * Copyright (C), 2010-2015, 赛捷软件（上海有限公司）.
 * Project Name:scrm-module-activity
 * File Name:ss.java
 * Package Name:com.sage.scrm.module.activity.repository.impl
 * Date:2015-8-11下午1:42:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
*/

package com.sage.scrm.vanke.module.pay.repository;

import com.sage.scrm.core.repository.BaseRepository;
import com.sage.scrm.vanke.module.pay.mapper.PayinfoMapper;
import com.sage.scrm.vanke.module.pay.model.Payinfo;

/**
 * ClassName:活动 <br/>
 * Date: 2015-8-11 下午1:42:05 <br/>
 * scrmVersion 1.0
 * @author   mennan
 * @version  jdk1.7
 * @see 	 
 */
public interface PayinfoRepository extends BaseRepository<Payinfo, PayinfoMapper>{
	
	
	String findIsMember(String mobile);
	
	String findIsCollect(String memberId);
	
	int findIsPay(String memberId);
	
}

