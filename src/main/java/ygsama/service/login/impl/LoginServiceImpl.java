package ygsama.service.login.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ygsama.common.EncryptUtil;
import ygsama.common.RetCodeEnum;
import ygsama.common.StringUtil;
import ygsama.domain.User;
import ygsama.persistence.UsersMapper;
import ygsama.pojo.UsersWithBLOBs;
import ygsama.service.login.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	private static Log log = LogFactory.getLog(LoginServiceImpl.class);

	@Autowired
	private UsersMapper usersMapper;
	
//	@Autowired
//	private SysMenuMapper sysMenuMapper;
	
	public User login(Map<String, Object> params) {
		log.info("------------[login]loginService-------------");
		User aUser = new User();
		try {
			// 取出参数
			String uid 	= StringUtil.parseString(params.get("uid"));
			String pwd  = StringUtil.parseString(params.get("pwd"));
			String loginIp 	 = StringUtil.parseString(params.get("loginIp"));    //本次登录IP
			String loginTime = StringUtil.parseString(params.get("loginTime"));  //本次登录时间
//			String loginTerm = StringUtil.parseString(params.get("loginTerm"));  //本次登录终端
			
			// 登录逻辑
			UsersWithBLOBs userBlob = usersMapper.selectByPrimaryKey(uid);
			
			if (userBlob == null) {
				aUser.setMsg(RetCodeEnum.FAIL.getTip());
				aUser.setCode(RetCodeEnum.FAIL.getCode());
				return aUser;
			}
			String md5 = EncryptUtil.MD5(userBlob.getPwd());
			if (!md5.equals(pwd)) {
				aUser.setMsg(RetCodeEnum.FAIL.getTip());
				aUser.setCode(RetCodeEnum.FAIL.getCode());
				return aUser;
			}	
			aUser.setCode(RetCodeEnum.SUCCEED.getCode());
			aUser.setMsg(RetCodeEnum.SUCCEED.getTip());
			// 登陆成功，返回aUser
			aUser.setNo(userBlob.getId());
			aUser.setLoginIp(userBlob.getLoginIp());      //上次登录IP
			aUser.setLoginTime(userBlob.getLoginTime());  //上次登录时间
			
			// 用户登录成功后更新用户信息
			aUser.setLoginTime(loginTime);  //本次登录时间
			aUser.setLoginIp(loginIp);      //本次登录IP
			usersMapper.updateByPrimaryKey(userBlob);
			
			log.info("[LoginService-Login]返回码=[" + aUser.getCode() + "] 返回信息=[" + aUser.getMsg() + "]");
			
		} catch (Exception e) {
			log.error("[Login] Fail:", e);
			aUser.setCode(RetCodeEnum.EXCEPTION.getCode());
			aUser.setMsg(RetCodeEnum.EXCEPTION.getTip());
		}
		return aUser;
	}
}
