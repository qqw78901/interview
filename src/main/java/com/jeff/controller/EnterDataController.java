package com.jeff.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.mConst;
import com.jeff.po.EnterData;
import com.jeff.po.Interviewee;
import com.jeff.po.Result;
import com.jeff.service.EnterDataService;
import com.jeff.service.IntervieweeService;
import com.jeff.service.ResultService;
import com.jeff.util.ResultMap;
import com.jeff.vo.EnterDataVo;
import com.jeff.vo.EntryVo;

@Controller
@RequestMapping("enter")
public class EnterDataController {
	@Autowired
	IntervieweeService intervieweeService;
	@Autowired
	EnterDataService enterDataService;
	@Autowired
	ResultService resultService;
	
	@RequestMapping("entry")
	@ResponseBody
	public ResultMap entry(HttpServletRequest request, @RequestBody EntryVo entryVo) {
		ResultMap rm = new ResultMap();
		try {
			Interviewee interviewee = new Interviewee();
			interviewee.setCard(entryVo.getCard());
			interviewee.setPhone(entryVo.getPhone());
			interviewee.setState(mConst.STATE_T);
			interviewee.setName(entryVo.getName());
			String intertvieweeId = UUID.randomUUID().toString();
			interviewee.setId(intertvieweeId);
			intervieweeService.add(interviewee);// 增加面试者
			List<EnterData> elements = entryVo.getElements();
			for (EnterData element : entryVo.getElements()) {
				element.setInterviewee(intertvieweeId);
			}
			int i = enterDataService.batchEntry(elements);
			//除了要加进enterData表之外还要加进result表 初始化报名数据;
			Result resultPo = new Result();
			 resultPo.setInterviewee(intertvieweeId);
			 resultPo.setInterviewId(entryVo.getInterview());
			 resultPo.setResult("H");//第一次加进去 就定义为 H 
			 resultService.addResult(resultPo);
			rm.success().info("报名成功").data(i);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("失败");
		}
		return rm;
	}

	@RequestMapping("detail")
	@ResponseBody
	public ResultMap detail(HttpServletRequest request, EnterData enterData) {
		ResultMap rm = new ResultMap();
		try {
			List<EnterDataVo> enterDatas = enterDataService.getByIntervieweeId(enterData.getInterviewee());
			rm.success().info("成功").data(enterDatas);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("失败");
		}
		return rm;
	}

}
