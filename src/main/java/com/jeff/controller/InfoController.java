package com.jeff.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.po.Info;
import com.jeff.service.InfoService;

@Controller
@RequestMapping("info")
public class InfoController {

	@Autowired
	public InfoService infoService;

	@RequestMapping("addinfo")
	@ResponseBody
	public String addinfo(HttpServletRequest request,Info info) {
		String rString="";
		try {
			infoService.update(info);
		    String jsonpCallback = request.getParameter("callback");//客户端请求参数  
		    rString=  jsonpCallback+"('success')";
		} catch (Exception e) {
			e.printStackTrace();
			rString= "";
		}
		return rString;

	}
	
	@RequestMapping(value="getinfo", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getInfo(HttpServletRequest request,Info info,HttpServletResponse response) {
		String rm="";
		try {
		
			response.setContentType("text/plain; charset=utf-8");
			Info i = infoService.getById(info.getId());
			String functionName = request.getParameter("callback");
			rm ="var JSONresult ={";
			System.out.println(i.getCla());
			rm+="cla:'"+i.getCla()+"',";
			rm+="name:'"+i.getName()+"',";
			rm+="psw:'"+i.getPsw()+"',";
			rm+="school:'"+i.getSchool()+"',";
			rm+="id:'"+i.getId()+"'";
			rm +="};"+functionName+"(JSONresult);";
		} catch (Exception e) {
			e.printStackTrace();
			rm="failed";
		}
		return rm;
	}

	

}
