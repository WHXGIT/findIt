package com.cogitationsoft.findit.util;

import org.junit.Test;

/**
 * @author: Andy
 * @date: 5/29/2018 4:49 PM
 * @description:
 * @version: 1.0
 */
public class MarkImageUtilsTest {

	@Test
	public void test(){
		Boolean re = MarkImageUtils.markImg("E:/IdeaWorkspace/findIt/src/main/webapp/public-resources/CredImg/idcard.jpg", "E:/IdeaWorkspace/findIt/src/main/webapp/public-resources/CredImg/mark.png",
				"E:/IdeaWorkspace/findIt/src/main/webapp/public-resources/CredImg/", "test",
				"jpg", null);
		System.out.println(re);
	}

	@Test
	public void test1(){
		CutName.getDoltResult("123.jpg");
	}
}
