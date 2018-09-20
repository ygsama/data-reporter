package com.zjft.bdp.common;

import java.io.Serializable;


public class UserSession implements Serializable {

	private static final long serialVersionUID = 2748862732649289013L;

	private String account; // 用户帐号

	private String name;   // 用户名称

	private String orgNo;  // 机构编号

	private String orgName; // 机构名称
	
	private int orgGrade; //机构等级
	
	private int roleNo; // 用户角色编号
	
	private String roleName; // 用户角色名称
	
	private int roleCatalog; //用户角色类型
	
	private String areaNo;//用户所属区域
	
	private String loginIp;//用户上次登录IP
	
	private String loginTime;//用户上次登录时间

	private int online_flag;//登录标志
	
	private String loginIp_curr; //用户此次登录IP
	
	private String loginTime_curr;//用户此次登录时间
	
	private String lastOperateTime;  //用户最近一次操作时间
	
	public int getRoleCatalog() {
		return roleCatalog;
	}
	
	public void setRoleCatalog(int roleCatalog) {
		this.roleCatalog = roleCatalog;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}

	public int getOrgGrade() {
		return orgGrade;
	}

	public void setOrgGrade(int orgGrade) {
		this.orgGrade = orgGrade;
	}

	public String getAreaNo() 
	{
		return areaNo;
	}

	public void setAreaNo(String areaNo) 
	{
		this.areaNo = areaNo;
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

	public int getOnline_flag() {
		return online_flag;
	}

	public void setOnline_flag(int online_flag) {
		this.online_flag = online_flag;
	}

	public String getLoginIp_curr() {
		return loginIp_curr;
	}

	public void setLoginIp_curr(String loginIp_curr) {
		this.loginIp_curr = loginIp_curr;
	}

	public String getLoginTime_curr() {
		return loginTime_curr;
	}

	public void setLoginTime_curr(String loginTime_curr) {
		this.loginTime_curr = loginTime_curr;
	}

	public String getLastOperateTime() {
		return lastOperateTime;
	}

	public void setLastOperateTime(String lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}
}
