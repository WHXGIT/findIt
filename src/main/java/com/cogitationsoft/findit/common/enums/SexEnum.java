package com.cogitationsoft.findit.common.enums;

/**
 * @author: Andy
 * @date: 5/8/2018 5:01 PM
 * @description: SexEnum
 * @version: 1.0
 */
public enum SexEnum {

	MALE(1), FEMALE(0), UNKNOWN(2);

	private int value;
	SexEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
