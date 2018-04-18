package com.core.exception;

import com.core.enums.ExCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class OperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 异常代号
	private int code = ExCode.OPRERROR.getCode();

	private String message = "";
	
	private String key = "";

	/**
	 * 构造方法
	 */
	public OperationException() {
	}

	/**
	 * 构造方法
	 * 
	 * @param message
	 */
	public OperationException(String message) {
		Matcher m = Pattern.compile("(\\{[^\\}]+})").matcher(message);
		while (m.find()){
			key = m.group(1).replace("{", "").replace("}", "");
			//this.message += G.getMsg(key);
			this.message += key;
		}
		if (this.message.length()==0) this.message = message;
	}

	/**
	 * 获取错误提示信息
	 * 
	 * @param request
	 * @return
	 */
	public String getMessage() {
		return this.message;
	}
	
	public String getKey() {
		return this.key;
	}

	/**
	 * 获取异常代号
	 * 
	 * @return
	 */
	public int code() {
		return this.code;
	}

}
