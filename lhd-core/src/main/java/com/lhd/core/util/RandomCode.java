/**
 * 
 */
package com.lhd.core.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author lhd
 * @创建日期 2014-11-20
 * @版本 V 1.0
 */
public class RandomCode {
	public static String strCode = null;
	public static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
			'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static Random random = new Random();

	// 获取四位随机数
	public static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		strCode = buffer.toString();
		return strCode;
	}

	// 获取随机颜色
	public static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255));
	}

	// 返回某颜色的反色
	public static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(),
				255 - c.getBlue());
	}

	/**
	 * 创建图片
	 * @return 验证码的流格式
	 */
	public BufferedImage createImage() {
		String randomString = getRandomString();// 获取随机字符串

		int width = 80;// 设置图片的宽度
		int height = 30;// 高度

		Color color = getRandomColor();// 获取随机颜色，作为背景色
		Color reverse = getReverseColor(color);// 获取反色，用于前景色

		// 创建一个彩色图片
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();// 获取绘制对象
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 23));// 设置字体

		g.setColor(color);// 设置颜色

		g.fillRect(0, 0, width, height);// 绘制背景
		g.setColor(reverse);// 设置颜色
		g.drawString(randomString, 5, 23);

		// 最多绘制100个噪音点
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}

		// 返回验证码图片的流格式
		//ByteArrayInputStream bais = convertImageToStream(image);

		return image;

	}


}
