package com.cogitationsoft.findit.util;

import com.cogitationsoft.findit.common.enums.SexEnum;
import org.junit.Test;

/**
 * @author: Andy
 * @date: 5/10/2018 6:21 PM
 * @description:
 * @version: 1.0
 */
public class Ma {

	@Test
	public void testCodeUtil(){
		String re = DoCodeUtil.doCode("1234567890");
		System.out.println(re);
	}
}
