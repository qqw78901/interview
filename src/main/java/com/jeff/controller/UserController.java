package com.jeff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.common.mConst;
import com.jeff.mybatis.page.Page;
import com.jeff.po.User;
import com.jeff.service.UserService;
import com.jeff.util.ResultMap;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping("add")
	@ResponseBody
	public ResultMap add(HttpServletRequest request,User user) {
		ResultMap rm = new ResultMap();
		try {
			user.setState(mConst.STATE_T);
			if(!BaseInfo.GetUserGradeId(request).equals("1")) {
				user.setGradeId("3");
				user.setDeptId(BaseInfo.GetUserDeptId(request));
			}
			userService.add(user);
			rm.success().info("增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("增加失败");
		}
		return rm;
	}

	@RequestMapping("list")
	@ResponseBody
	public ResultMap list() {
		ResultMap rm = new ResultMap();
		try {
			User user = new User();
			user.setId(null);
			List<User> list = userService.list(user);
			rm.success().data(list);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("fail");
		}
		return rm;
	}

	@RequestMapping("page")
	@ResponseBody
	public ResultMap page(HttpServletRequest request,User user,String search) {
		ResultMap rm = new ResultMap();
		try {
			user.setId(null);
			user.setState(mConst.STATE_T);
			if(search!=null&&search!="") {
				user.setLoginName(search);
			}
			if(!BaseInfo.GetUserGradeId(request).equals("1")) {
				user.setGradeId("3");
				user.setDeptId(BaseInfo.GetUserDeptId(request));
			}
			Page<User> list = userService.findByPage(user);
			rm.success().page(list);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("fail");
		}
		return rm;
	}
	
	@RequestMapping("check")
	@ResponseBody
	public Boolean check(User user) {
		try {
			User us = userService.check(user);
			if(us!=null) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return true;
		
	}
	@RequestMapping("remove")
	@ResponseBody
	public ResultMap remove(User user) {
		ResultMap rm = new ResultMap();
		try {
			user.setState(mConst.STATE_F);
			userService.update(user);
			rm.success().info("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("删除失败");
		}
		return rm;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultMap update(User user) {
		ResultMap rm  = new ResultMap();
		try {
			user.setLoginName(null);
			userService.update(user);
			rm.success().info("修改成功");
		} catch (Exception e) {
			rm.fail().info("修改失败");
		}
		return rm;
	}

}
