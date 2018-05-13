package com.cogitationsoft.findit.common.exception;

/**
 * @author: Andy
 * @date: 5/10/2018 4:13 PM
 * @description: 登录异常
 * @version: 1.0
 */
public class LoginException extends Exception {
	private String message;

	public LoginException(String message){
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
