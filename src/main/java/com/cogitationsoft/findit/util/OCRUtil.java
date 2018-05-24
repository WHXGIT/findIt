package com.cogitationsoft.findit.util;

import com.youtu.Youtu;
import org.json.JSONObject;

/**
 * @author: Andy
 * @date: 5/24/2018 4:43 PM
 * @description: 身份证识别
 * @version: 1.0
 */
public class OCRUtil {
	public static final String APP_ID = "10132838";
	public static final String SECRET_ID = "AKIDBMMCg3yH8oLm275kLBSbZLvNew666m1B";
	public static final String SECRET_KEY = "AAyb6QfjcKqAJRUL3Zu31yoS0Pg8q241";
	public static final String USER_ID = "1142468658"; //qq号

	public static Youtu getYoutuOCR() {
		Youtu faceYoutu = null;
		try {
			faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY, Youtu.API_YOUTU_END_POINT, USER_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faceYoutu;
	}
}
