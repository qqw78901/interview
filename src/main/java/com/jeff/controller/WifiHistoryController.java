package com.jeff.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.common.mConst;
import com.jeff.po.WifiCourse;
import com.jeff.po.WifiHistory;
import com.jeff.service.WifiCourseService;
import com.jeff.service.WifiHistoryService;
import com.jeff.util.ResultMap;
import com.jeff.vo.CheckinVo;

@Controller
@RequestMapping("wifihistory")
public class WifiHistoryController {

	@Autowired
	public WifiHistoryService wifiHistoryService;
	@Autowired
	public WifiCourseService wifiCourseService;

	
	@RequestMapping("checkin")
	@ResponseBody
	public ResultMap checkin(HttpServletRequest request,CheckinVo checkinVo) {
		ResultMap rs = new ResultMap();
		try {
			String loginName = BaseInfo.GetUserName(request);
			String info="签到成功";
			//先判断是否已经登录
			if(loginName==null) {
				return rs.fail().info("用户未登录");
			}else if(loginName.equals("")) {
				return rs.fail().info("用户未登录");
			}
			//在判断是否本人
			String sessionMac = BaseInfo.GetMac(request);
			if (!sessionMac.equals(checkinVo.getMac())) {
				//如果mac不对
				info =  "签到成功。警告！手机mac地址验证未通过，登记mac为："+sessionMac;
			}
			WifiCourse course  =  new WifiCourse();
			course.setMac(checkinVo.getAssid());
			
			course = wifiCourseService.findCourse(course);
			//获取到课程 course
			if(course==null) {
				return rs.fail().info("assid未对应或课程已经关闭签到");
			}else if(course.getId().equals("")){
				return rs.fail().info("assid未对应或课程已经关闭签到");
			}else if(course.getSsid().equals(checkinVo.getSsid())) {
				return rs.fail().info("警告 ssid未对应");
			}
			WifiHistory history = new WifiHistory();
			history.setId(UUID.randomUUID().toString());
			history.setCourseId(course.getId());
			history.setCreateDt(new Date());
			history.setCreateIp(BaseInfo.GetIp(request));
			history.setState(mConst.STATE_T);
			history.setCreateId(BaseInfo.GetUserName(request));
			history.setMac(checkinVo.getMac());
			wifiHistoryService.add(history);
			info +="出口ip:"+history.getCreateIp();
			String nString = Integer.toString(wifiCourseService.count(course));
			rs.put("num", nString);
			info+="已签到人数:"+nString;
			rs.success().info(info);
			
		} catch (Exception e) {
			e.printStackTrace();
			rs.fail().info("签到失败");
		}
		
		return rs;
		
	}
	
	@RequestMapping("checked")
	@ResponseBody
	public ResultMap checked(HttpServletRequest request,WifiHistory wifiHistory) {
		ResultMap rs = new ResultMap();
		try {
			
			rs.success().info("成功").data(wifiHistoryService.checked(wifiHistory));
		} catch (Exception e) {
			rs.fail().info("失败");
		}
		return rs;
	}


	

}
