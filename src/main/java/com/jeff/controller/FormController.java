package com.jeff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.po.Form;
import com.jeff.po.FormTh;
import com.jeff.service.FormService;
import com.jeff.service.FormThService;
import com.jeff.util.ResultMap;
import com.jeff.vo.FormInsertVo;


@Controller
@RequestMapping("form")
public class FormController {
	@Autowired
	FormService formService;
	@Autowired
	FormThService formThService;
	
	@RequestMapping("show")
	@ResponseBody
	public ResultMap show(HttpServletRequest request,Form form) {
		ResultMap rm = new ResultMap();
		try {
			rm.success().data(formService.show(form)).info("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查询失败");
		}
		return rm;
	}
	
	@RequestMapping("insertForm")
	@ResponseBody
	public ResultMap insetForm(HttpServletRequest request,@RequestBody FormInsertVo formInsertVo){
		ResultMap rm = new ResultMap();
		try {
			Form form = formInsertVo.getForm();
			form.setDeptId(BaseInfo.GetUserDeptId(request));
			List<FormTh> formthes = formInsertVo.getElements();
            if(formthes==null)
                return rm.fail().info("请输入问题");    
            formService.add(form);
            formThService.batchFormTh(formthes);
			rm.success().info("增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			Form form = formInsertVo.getForm();
			formService.remove(form.getId());
			rm.fail().info("增加失败");
		}
		return rm;
	}
	
	@RequestMapping("getPublicFormByPage")
	@ResponseBody
	public ResultMap getPublicFormByPage(HttpServletRequest request,Form form) {
		ResultMap rm = new ResultMap();
		try {
			rm.success().page(formService.getPublicFormByPage(form)).info("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查询失败");
		}
		return rm;
	}
	
	@RequestMapping("getFormByPage")
	@ResponseBody
	public ResultMap getFormByPage(HttpServletRequest request,Form form) {
		ResultMap rm = new ResultMap();
		try {
			form.setDeptId(BaseInfo.GetUserDeptId(request));
			rm.success().page(formService.getByPage(form)).info("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查询失败");
		}
		return rm;
	}
	
	@RequestMapping("remove")
	@ResponseBody
	public ResultMap remove(HttpServletRequest request,String id) {
		ResultMap rm =  new ResultMap();
		try {
			formService.remove(id);
			rm.success().info("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("删除失败");
		}
		return rm;
	}
	
	


}
