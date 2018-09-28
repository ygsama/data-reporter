package ygsama.common;

public enum RetCodeEnum {
	
	SUCCEED("00", "成功"),
	
	FAIL("FF", "失败"),
	
	EXCEPTION("FE", "异常"),
	
	BUSY("F3", "结果为空"),
	
	RESULT_EMPTY("F1", "结果为空");
	
	
	
	private String code;
	private String tip;

	private RetCodeEnum(String code, String tip) {
		this.code = code;
		this.tip = tip;
	}

	public String getCode() {
		return this.code;
	}

	public String getTip() {
		return this.tip;
	}
	
	public static String getTipByCode(String code) {
		for (RetCodeEnum temp : RetCodeEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp.getTip();
			}
		}
		return "";
	}

}
