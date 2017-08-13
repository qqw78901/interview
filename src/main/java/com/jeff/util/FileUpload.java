package com.jeff.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by shhao. Date: 14-9-1 Time:下午4:12
 */
public class FileUpload {

	// 文件上传
	// uuid文件名
	public static String uploadFile(MultipartFile file,
			HttpServletRequest request, String filedoc) throws IOException {
		String fileName = file.getOriginalFilename();
		String flieType = fileName.substring(fileName.indexOf('.'),
				fileName.length());
		File tempFile = new File(filedoc, UUID.randomUUID().toString()
				.replace("-", "")
				+ flieType);
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdir();
		}
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		// file.transferTo(tempFile);
		/**
		 * spring提供的transferTo方法可能不会及时关闭io流 ，所以当上传完一个文件然后马上更新的时候会引起io异常
		 * 无法删除前一个文件 故使用传统的存盘方法
		 */
		FileUpload.save(file, tempFile);
		return tempFile.getName();
	}

	// 文件上传
	// 自定义文件名
	public static String uploadFile(MultipartFile file,
			HttpServletRequest request, String filedoc, String myFileName)
			throws IOException {
		String fileName = file.getOriginalFilename();
		String flieType = fileName.substring(fileName.indexOf('.'),
				fileName.length());
		File tempFile = new File(filedoc, myFileName + flieType);
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdir();
		}
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		// file.transferTo(tempFile);
		/**
		 * spring提供的transferTo方法可能不会及时关闭io流 ，所以当上传完一个文件然后马上更新的时候会引起io异常
		 * 无法删除前一个文件 故使用传统的存盘方法
		 */
		FileUpload.save(file, tempFile);
		return tempFile.getName();
	}

	public static void save(MultipartFile file, File tempFile)
			throws IOException {
		InputStream is = file.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = is.read(buf)) > 0) {
			// 这里就可以把输入流输出到一个直接数组流中
			baos.write(buf, 0, len);
		}
		byte[] fs = baos.toByteArray();
		FileOutputStream fos = new FileOutputStream(tempFile);
		fos.write(fs, 0, fs.length);
		fos.close();
	}

	public static File getFile(String fileName) {
		return new File(fileName);
	}
}