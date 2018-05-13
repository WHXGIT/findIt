package com.cogitationsoft.findit.common.exception;

/**
 * @author: Andy
 * @date: 5/11/2018 1:46 PM
 * @description: User object translation Exception
 * @version: 1.0
 */
public class UserDTOException extends Exception{
	private String message;

	public UserDTOException(String message){
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
