package com.sage.scrm.vanke.module.pay.mapper;

import java.util.List;

import com.sage.scrm.core.mapper.BaseMapper;
import com.sage.scrm.vanke.module.pay.model.Actitypayconfig;

public interface ActitypayconfigMapper extends BaseMapper<Actitypayconfig>{
	
	List<Actitypayconfig> selectByStatus(String status);
	
}