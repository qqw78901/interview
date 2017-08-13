package com.jeff.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public final class QRcodeUtil {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	private QRcodeUtil() {
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format "
					+ format + " to " + file);
		}
	}

	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}
	}

	public static void getQRcode(String content, String fileName) {
		try {
			String path = PropertiesUtil.getUploadProp()
					.getProperty("qrcodePath");
			FileUtil.markDir(path);
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content,
					BarcodeFormat.QR_CODE, 400, 400, hints);
			File file1 = new File(path, fileName + ".jpg");
			QRcodeUtil.writeToFile(bitMatrix, "jpg", file1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向页面生成登录二维码，默认大小为300×300，jpg格式
	 * @param content 二维码内容
	 */
	public static void outToWeb(String content, HttpServletResponse response) {
		response.setContentType("image/jpeg");
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content,
					BarcodeFormat.QR_CODE, 300, 300, hints);
			QRcodeUtil.writeToStream(bitMatrix, "jpg",
					response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 向页面生成登录二维码，默认大小为300×300，jpg格式
	 * @param content 二维码内容
	 * @param filename 下载的文件名称,默认jpg格式
	 */
	public static void downloadQRcode(String content,String filename, HttpServletResponse response) {
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content,
					BarcodeFormat.QR_CODE, 300, 300, hints);
			response.setContentType("image/jpeg;charset=UTF-8");
			filename += ".jpg";
			response.setHeader("Content-disposition",
					"attachment;filename=" + new String(filename.getBytes("utf-8"), "ISO_8859_1"));
			QRcodeUtil.writeToStream(bitMatrix, "jpg",
					response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
