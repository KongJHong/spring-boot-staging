package com.hong.common.exception;

/**
 * Description     : 异常提示信息枚举类
 */
public enum ExceptionEnum {
	/* 输入异常 1xx */
	PARAMETER_EXCEPTION("102","参数异常"),

	PARAMETER_MISSING_EXCEPTION("103","缺少必要的请求参数"),

	/* 系统异常 5xx */
	UNEXPECTED_EXCEPTION("500","系统异常，请联系管理员")
	;
	private String code;
	private String msg;

	private ExceptionEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
