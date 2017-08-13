package com.jeff.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.mybatis.page.Page;
import com.jeff.po.Form;
import com.jeff.po.Interview;
import com.jeff.po.Result;
import com.jeff.service.FormService;
import com.jeff.service.InterviewService;
import com.jeff.service.ResultService;
import com.jeff.util.ExcelFile;
import com.jeff.util.ResultMap;
import com.jeff.vo.IntervieweeResultVo;
import com.jeff.vo.ResultVo;

@Controller
@RequestMapping("result")
public class ResultController {
	@Autowired
	ResultService resultService;
	@Autowired
	InterviewService interviewService;
	@Autowired
	FormService formService;
	
	@RequestMapping("showAllbyPage")
	@ResponseBody
	public ResultMap showAllResultbyPage(HttpServletRequest request, ResultVo resultVo) {
		ResultMap rm = new ResultMap();
		try {
			Interview iw = new Interview();
			Page<ResultVo> pg;
			iw = interviewService.getById(resultVo.getInterviewId());
			if (iw == null)
				return rm.fail().info("面试不存在");
			if (iw.getDeptId().equals(BaseInfo.GetUserDeptId(request))) {
				pg = resultService.showAllResultbyPage(resultVo);

			} else {
				pg = resultService.buildVoPage(null);
			}
			rm.success().page(pg).info("查询成功");

		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查询失败");
		}
		return rm;
	}

	@RequestMapping("set")
	@ResponseBody
	public ResultMap set(HttpServletRequest request, Result result) {
		ResultMap rm = new ResultMap();
		try {
			String resuString = result.getResult();
			Interview iw = new Interview();
			result = resultService.getInterview(result);// 获取当前result的interviewId
			result.setResult(resuString);// 重赋值String-result
			iw = interviewService.getById(result.getInterviewId());
			if (iw.getDeptId().equals(BaseInfo.GetUserDeptId(request))) {// 不让其他dept的人操作
				resultService.set(result);
				rm.success().info("设置成功");
			} else {
				rm.fail().info("无权限操作该组织面试");
			}

		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("设置失败");
		}
		return rm;
	}

    @RequestMapping("remove")
	@ResponseBody
	public ResultMap remove(HttpServletRequest request, Result result) {
		ResultMap rm = new ResultMap();
		try {
	/*		Interview iw = new Interview();
			result = resultService.getInterview(result);// 获取当前result的interviewId
			iw = interviewService.getById(result.getInterviewId());
			if (iw.getDeptId().equals(BaseInfo.GetUserDeptId(request))) {// 不让其他dept的人操作
*/				resultService.remove(result);
				rm.success().info("删除成功");
	/*		} else {
				rm.fail().info("无权限操作该组织面试");
			}*/

		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("设置失败");
		}
		return rm;
	}

	@RequestMapping("select")
	@ResponseBody
	public ResultMap select(ResultVo resultVo) {
		ResultMap rm = new ResultMap();
		try {
			Page<IntervieweeResultVo> page = resultService.selectIntervieweeByPage(resultVo);
			rm.success().page(page);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail();
		}
		return rm;
	}

	@RequestMapping("export")
	@ResponseBody
	public void exportIntervieweeSummary(String interview, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ExcelFile excelFile = resultService.getInterviewSummary(interview);
			if (excelFile != null) {
				Interview i =interviewService.getById(interview);
				excelFile.save(request, response, i.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("know")
	@ResponseBody
	public ResultMap Konw(HttpServletRequest request, String form,
			ResultVo resultVo) {
		ResultMap rm = new ResultMap();
		try {
			if (resultVo.getName() == null || resultVo.getCard() == null)
				return rm.fail().info("缺少姓名或证件号");
			if(resultVo.getName().equals("") || resultVo.getCard().equals(""))
				return rm.fail().info("缺少姓名或证件号");
			Form formPo = new Form();
			formPo = formService.getById(form);
			if (formPo == null)
				return rm.fail().info("无效报名表");

			resultVo.setInterviewId(formPo.getInterviewId());
			Page<IntervieweeResultVo> page = resultService
					.selectIntervieweeByPage(resultVo);
			rm.success().page(page);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail();
		}
		return rm;
	}
}
