package com.zjft.bdp.service.login;

import java.util.List;
import java.util.Map;

import com.zjft.bdp.common.IRetInfo;
import com.zjft.bdp.domain.Menu;
import com.zjft.bdp.domain.User;


/*
 * 登录逻辑
 */
public interface LoginService extends IRetInfo{
	
	public User login(Map<String, Object> paramsMap);
	

}
