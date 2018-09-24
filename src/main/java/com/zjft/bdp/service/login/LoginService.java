package com.zjft.bdp.service.login;

import java.util.Map;

import com.zjft.bdp.domain.User;


/*
 * 登录逻辑
 */
public interface LoginService {
	
	public User login(Map<String, Object> paramsMap);
	

}
