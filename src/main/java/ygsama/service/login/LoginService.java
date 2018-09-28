package ygsama.service.login;

import java.util.Map;

import ygsama.domain.User;


/*
 * 登录逻辑
 */
public interface LoginService {
	
	public User login(Map<String, Object> paramsMap);
	

}
