package com.jeff.controller.user;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.common.mConst;
import com.jeff.po.Interview;
import com.jeff.service.InterviewService;
import com.jeff.util.ResultMap;


@Controller
@RequestMapping("interview")
public class InterviewController {
	@Autowired
	InterviewService interviewService;
	
	@RequestMapping("page")
	@ResponseBody
	public ResultMap page(HttpServletRequest request,Interview interview) {
		ResultMap rm = new ResultMap();
		try {
			interview.setDeptId(BaseInfo.GetUserDeptId(request));
			rm.success().page(interviewService.selectByPage(interview));
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查询失败");
		}
		return rm;
		
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultMap add(HttpServletRequest request,Interview interview) {
		ResultMap rm = new ResultMap();
		try {
			interview.setState(mConst.STATE_T);
			interview.setFollowBy(null);
			interview.setIsPublic(mConst.STATE_F);
			interview.setDeptId(BaseInfo.GetUserDeptId(request));		
			interview.setPath("/"+interview.getId());
			interviewService.add(interview);
			rm.success().info("增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("增加失败");
		}
		return rm;
	}
	
	
	@RequestMapping("addnext")
	@ResponseBody
	public ResultMap addNext(HttpServletRequest request,Interview interview) {
		ResultMap rm = new ResultMap();
		try {
			if(interviewService.checkChild(interview)>0) {
				return rm.fail().info("当前级已有面试,无法添加");
			}
			Interview parent =interviewService.getById(interview.getId());
			
			interview.setState(mConst.STATE_T);
			interview.setIsPublic(mConst.STATE_F);
			interview.setFollowBy(interview.getId());
			interview.setDeptId(BaseInfo.GetUserDeptId(request));
			interview.setId(UUID.randomUUID().toString());
			interview.setPath(parent.getPath()+"/"+interview.getId());
			interviewService.add(interview);
			rm.success().info("增加下级成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("增加下级失败");
		}
		return rm;
	}
	
	@RequestMapping("change")
	@ResponseBody
	public ResultMap change(HttpServletRequest request,Interview interview) {
		ResultMap rm = new ResultMap();
		try {
			interviewService.change(interview);
			rm.success().info("成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("失败");
		}
		return rm;
	}
	
	@RequestMapping("remove")
	@ResponseBody
	public ResultMap remove(HttpServletRequest request,Interview interview) {
		ResultMap rm = new ResultMap();
		try {
			if(interviewService.checkChild(interview)>0) {
				return rm.fail().info("下级还有面试,无法删除");
			}
			interview.setState(mConst.STATE_F);
			interviewService.change(interview);
			rm.success().info("成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("失败");
		}
		return rm;
	}
	
	@RequestMapping("getbyId")
	@ResponseBody 
	public ResultMap getbyId(String interview) {
		ResultMap rm = new ResultMap();
		try {
			rm.success().info("成功").data(interviewService.getById(interview));
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("失败");
		}
		return rm;
	}
	
	@RequestMapping("current")
	@ResponseBody 
	public ResultMap getCurrent(HttpServletRequest request) {
		ResultMap rm = new ResultMap();
		try {
			Interview interview = new Interview();
			interview.setDeptId(BaseInfo.GetUserDeptId(request));
			rm.success().info("查找成功").data(interviewService.getCurrent(interview));
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查找失败");
		}
		return rm;
	}
}
