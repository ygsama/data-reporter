package com.zjft.bdp.common;

import java.io.Serializable;
import java.util.Locale;


public class UserToken implements Serializable {

	private static final long serialVersionUID = 2748862732649289013L;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getOnline_flag() {
		return online_flag;
	}

	public void setOnline_flag(int online_flag) {
		this.online_flag = online_flag;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLastOperateTime() {
		return lastOperateTime;
	}

	public void setLastOperateTime(String lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}

	
	
	private String webToken; // 用户tokenID
	public String getWebToken() {
		return webToken;
	}

	public void setWebToken(String webToken) {
		this.webToken = webToken;
	}



	private Locale lang; // 用户语种
	
	public Locale getLang() {
		return lang;
	}

	public void setLang(Locale lang) {
		this.lang = lang;
	}



	private String userId; // 用户帐号

	private String userName;   // 用户名称

	private String companyId;  // 公司编号

	private String companyName; // 公司名称
	
	private int roleId; // 用户角色编号
	
	private String roleName; // 用户角色名称
	
	private String lastLoginIp;//用户上次登录IP
	
	private String lastLoginTime;//用户上次登录时间

	private int online_flag;//登录标志
	
	private String loginIp; //用户此次登录IP
	
	private String loginTime;//用户此次登录时间
	
	private String lastOperateTime;  //用户上一次操作时间

	
}
