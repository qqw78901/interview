package com.jeff.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.common.mConst;
import com.jeff.po.WifiCourse;
import com.jeff.service.WifiCourseService;
import com.jeff.util.ResultMap;

@Controller
@RequestMapping("wificourse")
public class WifiCourseController {

	@Autowired
	public WifiCourseService wifiCourseService;

	@RequestMapping("openwifi")
	@ResponseBody
	public ResultMap openWifi(HttpServletRequest request,WifiCourse wifiCourse) {
		ResultMap rs = new ResultMap();
		try {
			String loginName = BaseInfo.GetUserName(request);
			System.out.println("*************************************************");
			System.out.println(wifiCourse.getMac());
			System.out.println(wifiCourse.getSsid());
			System.out.println("*************************************************");
			//未登录不允许操作
			if(loginName==null) {
				return rs.fail().info("用户未登录");
			}else if(loginName.equals("")) {
				return rs.fail().info("用户未登录");
			}
			wifiCourse.setUserId(loginName);
			List<WifiCourse> wifiCourses = wifiCourseService.check(wifiCourse);
			if(!wifiCourses.isEmpty()) {
				//数据库中 存在该user的public为T的课程，即课程热点已经创建
				System.out.println("账号已创建课程，请先关闭现有热点");
				return rs.fail().info("账号已创建课程，请先关闭现有热点");			
			}else {
				String idString = UUID.randomUUID().toString();
				wifiCourse.setState(mConst.STATE_T);
				wifiCourse.setIsPublic(mConst.STATE_T);
				wifiCourse.setId(idString);
				wifiCourseService.add(wifiCourse);
				System.out.println("成功创建课程");
				rs.put("courseId",idString);
				rs.success().info("成功创建课程");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return rs;

	}
	
	@RequestMapping("closewifi")
	@ResponseBody
	public ResultMap closeWifi(HttpServletRequest request,WifiCourse wifiCourse) {
		ResultMap rs = new ResultMap();
		try {
			String loginName = BaseInfo.GetUserName(request);
			
			//未登录不允许操作
			if(loginName==null) {
				return rs.fail().info("用户未登录");
			}else if(loginName.equals("")) {
				return rs.fail().info("用户未登录");
			}
			wifiCourse.setUserId(loginName);
			String num =  "";
			try {
				num =Integer.toString(wifiCourseService.count(wifiCourse));
				System.out.println(num);
				wifiCourseService.closeWifi(wifiCourse);
				
			} catch (Exception e) {
				num="获取签到人数出错";
			}	
			rs.put("num",num);
			rs.success().info("成功关闭签到入口");
		} catch (Exception e) {
			e.printStackTrace();
			rs.fail().info("关闭签到出错");
		}
		return rs;

	}


	

}
