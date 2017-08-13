package com.jeff.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.util.QRcodeUtil;

@Controller
@RequestMapping("qcode")
public class QcodeController {

	@RequestMapping("get")
	@ResponseBody
	public void get(HttpServletRequest request,HttpServletResponse response) {
	
		try {
			String ip = request.getHeader("Referer");
			if(ip!=null){
				QRcodeUtil.outToWeb(ip,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@RequestMapping("download")
	@ResponseBody
	public void download(String form,HttpServletRequest request,HttpServletResponse response) {
		
		try {
			if(form!=null) {
				String url= request.getRequestURL().toString().replace("/qcode/download.do","/pages/entry/entry.jsp?form="+form);	
				QRcodeUtil.downloadQRcode(url, "qcode", response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping("getbyform")
	@ResponseBody
	public void getbyForm(String form,HttpServletRequest request,HttpServletResponse response) {
		
		try {
		
			if(form!=null){
				QRcodeUtil.outToWeb(form,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
