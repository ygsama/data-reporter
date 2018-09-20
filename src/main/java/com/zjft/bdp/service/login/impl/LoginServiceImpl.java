package com.zjft.bdp.service.login.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zjft.bdp.common.RetCodeEnum;
import com.zjft.bdp.common.RetInfo;
import com.zjft.bdp.common.StringUtil;
import com.zjft.bdp.domain.User;
import com.zjft.bdp.service.login.LoginService;

@Service("loginService")
public class LoginServiceImpl extends RetInfo implements LoginService {
	
	private static Log log = LogFactory.getLog(LoginServiceImpl.class);

//	@Autowired
//	private OpTableMapper opTableMapper;
//	
//	@Autowired
//	private SysMenuMapper sysMenuMapper;
	
	public User login(Map<String, Object> params) {
		log.info("------------[login]loginService-------------");
		User aUser = new User();
		try {
			// 取出参数
			String no 		 = StringUtil.parseString(params.get("uid"));
			String password  = StringUtil.parseString(params.get("pwd"));
			String loginIp 	 = StringUtil.parseString(params.get("loginIp"));    //本次登录IP
			String loginTime = StringUtil.parseString(params.get("loginTime"));  //本次登录时间
			String loginTerm = StringUtil.parseString(params.get("loginTerm"));  //本次登录终端
			
//			// 登录逻辑
//			OpTable user = opTableMapper.selectDetailByPrimaryKey(no);
//			if (user == null) {
//				super.setRetMsg("用户不存在!");
//				return null;
//			} else {
//				String maxCount = "5";           //密码输入失败次数定为5次
//				if (!EncryptUtil.MD5(password).equals(user.getPasswd()) && user.getPasswdError() < Integer.parseInt(maxCount)
//						&& user.getStatus().intValue() != 2) {
//					if (user.getPasswdError() + 1 == Integer.parseInt(maxCount)) {
//						user.setStatus(2);
//						user.setPasswdError(user.getPasswdError() + 1);
//						opTableMapper.updateByPrimaryKeySelective(user);
//						super.setRetMsg("密码错误！无剩余输入机会！");
//						return null;
//					}
//					user.setPasswdError(user.getPasswdError() + 1);
//					opTableMapper.updateByPrimaryKeySelective(user);
//					super.setRetMsg("密码错误！剩余"+ String.valueOf(Integer.parseInt(maxCount) - user.getPasswdError())+"次输入机会！");
//					return null;
//				}
//				
//				if (user.getStatus().intValue() == 2) {
//					super.setRetMsg("用户被锁定");
//					return null;
//				}
//
//				if (user.getOrg() == null) {
//					super.setRetMsg("用户机构不存在!");
//					return null;
//				} else {
//					if (user.getOrgTable().getStatus() == null || user.getOrgTable().getStatus().intValue() == 2) {
//						super.setRetMsg("用户机构被锁定!");
//						return null;
//					}
//				}
//				
//				if (user.getRole() == null) {
//					super.setRetMsg("用户角色不存在!");
//					return null;
//				}
//				
//				List<SysMenu> menus = sysMenuMapper.selectListByRoleNo(user.getRole());
//				if (menus == null || menus.isEmpty()) {
//					super.setRetMsg("用户角无权限!");
//					return null;
//				}
//			}
//			
//			super.setRetCode(RetCodeEnum.SUCCEED.getCode());
//			super.setRetMsg("登录成功！");
//			// 登陆成功，返回aUser

//			List<Menu> aMenu = this.qryMenuByRole(user.getRole());
//			
//			Role aRole = new Role();
//			aRole.setNo(user.getRole());
//			aRole.setName(user.getSysRole().getName());
//			aRole.setMenus(aMenu);
//			aRole.setCatalog(user.getSysRole().getCatalog());
//			
//			Org aOrg = new Org();
//			aOrg.setNo(user.getOrgTable().getNo());
//			aOrg.setName(user.getOrgTable().getName());
//			
//			OrgGrade aGrade = new OrgGrade();
//			aGrade.setNo(user.getOrgTable().getOrgGradeNo());
//			aOrg.setOrgGrade(aGrade);
//			
//			aUser.setNo(user.getNo());
//			aUser.setName(user.getName());
//			aUser.setOrg(aOrg);
//			aUser.setRole(aRole);
//			aUser.setLoginIp(user.getLoginIp());      //上次登录IP
//			aUser.setLoginTime(user.getLoginTime());  //上次登录时间
//			aUser.setOnline_flag(Integer.valueOf(user.getOnlineFlag()));
//			aUser.setUsrDefView(user.getUsrDefView());
//			aUser.setUsrDefScreenView(user.getUsrDefScreenView());
//			// 用户登录成功后更新用户信息
//			user.setPasswdError(0);
//			user.setLoginTime(loginTime);  //本次登录时间
//			user.setLoginIp(loginIp);      //本次登录IP
//			user.setLoginTerm(loginTerm);  //本次登录终端
//			opTableMapper.updateByPrimaryKeySelective(user);
			
			log.info("[LoginService-Login]返回码=[" + aUser.getCode() + "] 返回信息=[" + aUser.getMsg() + "]");
			
		} catch (Exception e) {
			log.error("[Login] Fail:", e);
			aUser.setCode(RetCodeEnum.EXCEPTION.getCode());
			aUser.setMsg(RetCodeEnum.EXCEPTION.getTip());
		}
		return aUser;
	}


}
