package ygsama.domain;

import ygsama.common.RetCodeEnum;

/**
 * 所有返回对象继承
 * 默认状态为成功
 * @author ygsama
 *
 */
public class Status {

	public String msg; 
	public String code;

	public Status() {
		this.msg = RetCodeEnum.SUCCEED.getTip();
		this.code = RetCodeEnum.SUCCEED.getCode();;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
