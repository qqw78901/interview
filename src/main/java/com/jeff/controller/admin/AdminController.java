package com.jeff.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.po.Admin;
import com.jeff.service.AdminService;
import com.jeff.util.HTMLRequest;
import com.jeff.util.ResultMap;
import com.jeff.vo.AdminLoginVo;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	public AdminService adminService;

	@RequestMapping("login")
	@ResponseBody
	public ResultMap login(AdminLoginVo adminLoginVo, HttpServletRequest request) {
		ResultMap rm = new ResultMap();
		try {
			// 判断验证码
			if (HTMLRequest.GetParameter(request, "yzm").equals(
					BaseInfo.Getyzm(request))) {
				Admin admin = adminService.login(adminLoginVo);
				if (admin != null) {	
					BaseInfo.SetUserName(request, admin.getLoginName());
					BaseInfo.SetName(request, admin.getName());
					BaseInfo.SetUserGradeId(request,admin.getGradeId());
					BaseInfo.SetUserDeptId(request, admin.getDeptId());
					BaseInfo.SetUserDeptName(request, admin.getDeptName());	 
					rm.success().info("success");
				} else {
					rm.success().info("fail");
					rm.success().msg("账号密码不匹配");
				}
			} else {
				rm.success().info("fail");
				rm.success().msg("验证码错误");
			}

		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("fail");
		}
		return rm;
	}
	

	@RequestMapping("logout")
	@ResponseBody
	public ResultMap logout(HttpServletRequest request) {
		ResultMap rm = new ResultMap();
		try {
			request.getSession().invalidate();
			rm.success().info("success");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("fail");
		}
		return rm;
	}

}
