package com.jeff.controller.user;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.po.Form;
import com.jeff.service.IntervieweeService;
import com.jeff.util.ResultMap;


@Controller
@RequestMapping("interviewee")
public class IntervieweeController {
	@Autowired
	IntervieweeService intervieweeService;
	
	@RequestMapping("selectee")
	@ResponseBody
	public ResultMap selectee(HttpServletRequest request,Form form) {
		ResultMap rm = new ResultMap();
		try {
			rm.success().info("查询成功").page(intervieweeService.selecteeByformIdByPage(form));
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查询失败");
		}
		return rm;
		
	}


}
