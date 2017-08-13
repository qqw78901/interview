package com.jeff.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//截图
public class ImageCut {
	
	public static void cut(String sourcePath,String sourceName,int targetW,int targetH){
		
        File file1 = new File(sourcePath + "/" + sourceName); //用file1取得图片名字
        String name = file1.getName();

        try {
            BufferedImage input = ImageIO.read(file1);
            BufferedImage inputbig = new BufferedImage(targetW, targetH, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = (Graphics2D) inputbig.getGraphics();
            g.drawImage(input, 0, 0,targetW,targetH,null); //画图
            g.dispose();
            inputbig.flush();
            
            String fname = name.substring(0, name.indexOf(".")) + "cut";
            
            ImageIO.write(inputbig, "jpg", new File(sourcePath + "/" + fname + ".jpg")); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		
	}
	
	
	public static void little(String sourcePath,String sourceName){
		
        File file1 = new File(sourcePath + "/" + sourceName); //用file1取得图片名字
        String name = file1.getName();

        try {
            BufferedImage input = ImageIO.read(file1);
            BufferedImage inputbig = new BufferedImage(90, 55, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = (Graphics2D) inputbig.getGraphics();
            g.drawImage(input, 0, 0,90,55,null); //画图
            g.dispose();
            inputbig.flush();


            String fname = name.substring(0, name.indexOf(".")) + "small";
            ImageIO.write(inputbig, "jpg", new File(sourcePath + "/" + fname + ".jpg")); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		
	}




}
