package com.sage.scrm.vanke.module.pay.mapper;

import com.sage.scrm.core.mapper.BaseMapper;
import com.sage.scrm.vanke.module.pay.model.Payinfo;

public interface PayinfoMapper extends BaseMapper<Payinfo> {
	
	String selectIsMember(String mobile);
	
	String selectIsCollect(String memberId);
	
	String selectIsCollect(String memberId,String activityId);
	
	int selectIsPay(String memberId);

	int selectIsPay(String memberId, String activityId);
	
}