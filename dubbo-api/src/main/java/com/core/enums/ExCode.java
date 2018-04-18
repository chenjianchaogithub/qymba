package com.core.enums;

public enum ExCode {
	/**
	 * 异常代码 600 没有权限代码
	 */
	NOPOWERS("没有权限", 600),

	/**
	 * 异常代码 601 没有登录或登录超时
	 */
	NOLONGIN("没有登录", 601),

	/**
	 * 异常代码 700 参数不正常
	 */
	PRMERROR("参数错误", 700),

	/**
	 * 异常代码 800 操作异常
	 */
	OPRERROR("操作错误", 800),

	/**
	 * 异常代码 800 注册异常
	 */
	NOVERIFY("注册异常", 900);

	private String description;

	private int code;

	ExCode(String description, int code) {
		this.description = description;
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public int getCode() {
		return this.code;
	}
}
