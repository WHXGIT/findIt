package com.cogitationsoft.findit.common.enums;

/**
 * @author: Andy
 * @date: 5/8/2018 5:46 PM
 * @description: AuthorityEnum
 * @version: 1.0
 */
public enum AuthorityEnum {
	USER(1), MANAGER(2);

	private int value;

	AuthorityEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Method Description:
	 * 〈通过value获取对应的枚举对象〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/10/2018 6:25 PM
	 */
	public static AuthorityEnum getEnum(int value) {
		for (AuthorityEnum examType : AuthorityEnum.values()) {
			if (value == examType.getValue()) {
				return examType;
			}
		}
		return null;
	}
}
