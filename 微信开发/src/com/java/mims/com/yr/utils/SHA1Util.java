package com.yr.utils;


import java.security.MessageDigest;

public class SHA1Util {

	/**
	 * 转换字节数组为十六进制字符串
	 * 
	 * @param b
	 * @return
	 */
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			stringBuffer.append(byteToHexString(b[i]));
		}
		return stringBuffer.toString();
	}

	/**
	 * 将一个字节转化成十六进制形式的字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 字符串SHA-1加密
	 * 
	 * @param string
	 * @return
	 */
	public static String encodeBySHA(String string) {
		if (string != null && !string.isEmpty()) {
			try {
				// 创建具有指定算法名称的信息摘要
				MessageDigest messageDigest = MessageDigest
						.getInstance("SHA-1");
				// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
				byte[] bytes = messageDigest.digest(string.getBytes());
				// 将得到的字节数组变成字符串返回
				string = byteArrayToHexString(bytes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return string;
	}
}
