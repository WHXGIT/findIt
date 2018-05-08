package com.cogitationsoft.findit.common.enums;

/**
 * @author: Andy
 * @date: 5/8/2018 5:39 PM
 * @description: StateEnum
 * @version: 1.0
 */
public enum StateEnum {
	NORMAL(1), SUSPICIOUS(2), FORBID(3);

	private int value;
	StateEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
