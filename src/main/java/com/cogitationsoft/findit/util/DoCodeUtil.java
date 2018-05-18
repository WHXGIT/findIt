package com.cogitationsoft.findit.util;

/**
 * @author: Andy
 * @date: 5/17/2018 3:27 PM
 * @description: 对输入的证件编号进行打码
 * @version: 1.0
 */
public class DoCodeUtil {

	public static String doCode(String code){
		String result = "";
		synchronized (DoCodeUtil.class){
			int codingLength = 4;
			String codePre = code.substring(0, codingLength);
			String star = "";
			if(code.length() - 2 * codingLength >= 0){
				for(int i = 0; i < code.length() - 2 * codingLength; i++){
					star += "*";
				}
			}
			String codeLast = code.substring(code.length() - codingLength , code.length());
			result = codePre + star + codeLast;
		}
		return result;
	}
}
