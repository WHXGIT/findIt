package com.cogitationsoft.findit.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: Andy
 * @date: 5/8/2018 3:07 PM
 * @description: MD5加密生成器
 * @version: 1.0
 */
public class GenerateBASE64MD5Util {
	/**
	 * Method Description:
	 * 〈先进行Base64加密，再进行MD5加密，然后再进行Base64加密〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/8/2018 4:43 PM
	 */
	public static String toDigest(String text) {
		String resultString = null;
		if (text == null) {
			return null;
		}
		try {
			BASE64Encoder b64Encoder = new BASE64Encoder();
			byte[] utfBytes = text.getBytes();
			String textBase64 = b64Encoder.encode(utfBytes);
			byte[] base64Bytes = textBase64.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(base64Bytes);
			byte[] md5Bytes = md.digest();
			resultString = b64Encoder.encode(md5Bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return resultString;
	}
}
