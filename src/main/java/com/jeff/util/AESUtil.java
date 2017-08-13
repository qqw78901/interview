package com.jeff.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 128位AES加密方案 Copyright (C), 
 * 
 * @ClassName: AESUtil
 * @author 
 * @date 2015年8月31日 下午1:42:50
 * 
 *       类用途:
 * 
 */
public class AESUtil {

	// 加密
	public static String Encrypt(String sSrc, String sKey) throws Exception {
		if (sKey == null) {
			System.out.print("Key为空null");
			return null;
		}
		// 判断Key是否为16位
		if (sKey.length() != 16) {
			System.out.print("Key长度不是16位");
			return null;
		}
		byte[] raw = sKey.getBytes("utf-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

		return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
	}

	// 解密
	public static String Decrypt(String sSrc, String sKey) throws Exception {
		try {
			// 判断Key是否正确
			if (sKey == null) {
				System.out.print("Key为空null");
				return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				System.out.print("Key长度不是16位");
				return null;
			}

			byte[] raw = sKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original, "utf-8");
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		/*
		 * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
		 * 此处使用AES-128-CBC加密模式，key需要为16位。
		 */
		String cSrc = "{key1:'11',key2:'22',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ ",key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试',key3:'33',key4:'测试'"
				+ "}";
		String cKey = "Y586U465l05Gv9H2";
		// 加密
		// EOst/jvv0Bf/RGRT8W63/hBXdhhMgu8ixJXf8vx1A8k
		// Z16O5LgL65N7xxgSAGcIpKwI6RXHJFwc LlMv1U4ar4=
		String enString = AESUtil.Encrypt("转运前需进行转运风险告知，签署转运知情同意书", cKey);
		System.out.println("加密后的字串是：" + enString);

		// 解密

		String DeString = AESUtil
				.Decrypt(
						"PzFoB9VE9XyMUnBNdSWenKjBOld9jLSK7oIyA0EXg2z6eU44WDRlc5+pIymGq2i6wFhPDF6sgVUC3D+F8m/eNy4cg8+7qgFALyW3a/hQxLs=",
						cKey);
		System.out.println("解密后的字串是：" + DeString);
	}

}
