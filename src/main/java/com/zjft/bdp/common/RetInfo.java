package com.zjft.bdp.common;

public class RetInfo {
	private String retMsg;
	private String retCode;
	public String getRetCode() {
		// TODO Auto-generated method stub
		return this.retCode;
	}

	public String getRetMsg() {
		// TODO Auto-generated method stub
		return this.retMsg;
	}

	public void setRetCode(String retCode) {
		// TODO Auto-generated method stub
		this.retCode = retCode;
	}

	public void setRetMsg(String retMsg) {
		// TODO Auto-generated method stub
		this.retMsg = retMsg;
		
	}
	
	public void initRet(){
		this.setRetCode("FF");
		this.setRetMsg("操作失败!");
	}
	
	public void setRetOK(){
		this.setRetCode("00");
		this.setRetMsg("操作成功!");
	}
}
