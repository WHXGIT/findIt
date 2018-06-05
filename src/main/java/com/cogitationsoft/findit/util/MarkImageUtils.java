package com.cogitationsoft.findit.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author: Andy
 * @date: 5/29/2018 3:30 PM
 * @description: 对证件添加打码
 * @version: 1.0
 */
public class MarkImageUtils {


	/**
	 * Method Description:
	 * 〈对上传的图片进行打码〉
	 *
	 * @param: null
	 * @return:
	 * @author: Andy
	 * @date: 5/29/2018 3:43 PM
	 */
	public static boolean markImg(String sourceImgPath, String markImgPath,
	                              String outputImgPath, String imgName,
	                              String imgType, Integer degree) {
		File sourceImgFile = new File(sourceImgPath);
		File markImgPathFile = new File(markImgPath);

		if (!sourceImgFile.isFile()) {
			return false;
		}

		Image sourceStream = null;
		Image markStream = null;

		try {
			//读入源图片
			sourceStream = ImageIO.read(sourceImgFile);
			//读入码图片
			markStream = ImageIO.read(markImgPathFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int markHeight = markStream.getHeight(null);
		int markWidth = markStream.getWidth(null);


		int sourceHeight = sourceStream.getHeight(null);
		int sourceWidth = sourceStream.getWidth(null);

		BufferedImage bufferedImage = new BufferedImage(sourceWidth, sourceHeight,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = bufferedImage.createGraphics();

		int x = sourceWidth / 3;
		int y = 3 * sourceHeight / 4;

		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2D.drawImage(sourceStream.getScaledInstance(sourceWidth, 4 * sourceHeight / 3 , Image.SCALE_SMOOTH), 0, 0, null);
		if (null != degree) {
			//设置水印旋转
			graphics2D.rotate(Math.toRadians(degree), (double) bufferedImage.getWidth() / 2, (double) bufferedImage.getHeight() / 2);
		}


		//水印图象的路径 水印一般为gif或者png的，这样可设置透明度
		ImageIcon imgIcon = new ImageIcon(markImgPath);

		//得到Image对象。
		Image con = imgIcon.getImage();
		//透明度，最小值为0，最大值为1
		float clarity = 0.9f;
		graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, clarity));

		//表示水印图片的坐标位置(x,y)
		//g.drawImage(con, 300, 220, null);
		graphics2D.drawImage(con, x, y, null);
		graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		graphics2D.dispose();
		File sf = new File(outputImgPath, imgName + "." + imgType);
		try {
			ImageIO.write(bufferedImage, imgType, sf); // 保存图片
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
