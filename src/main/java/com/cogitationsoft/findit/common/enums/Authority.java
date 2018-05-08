package com.cogitationsoft.findit.common.enums;

/**
 * @author: Andy
 * @date: 5/8/2018 5:46 PM
 * @description: AuthorityEnum
 * @version: 1.0
 */
public enum Authority {
	USER(1), MANAGER(2);

	private int value;

	Authority(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
