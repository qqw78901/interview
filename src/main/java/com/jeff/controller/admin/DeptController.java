package com.jeff.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.mConst;
import com.jeff.mybatis.page.Page;
import com.jeff.po.Dept;
import com.jeff.service.DeptService;
import com.jeff.util.ResultMap;

@Controller
@RequestMapping("dept")
public class DeptController {
	@Autowired
	public DeptService deptService;
	
	@RequestMapping("page")
	@ResponseBody
	public ResultMap page(Dept dept,String search) {
		ResultMap rm = new ResultMap();
		try {
			dept.setId(null);
			if(search!=null&&search!="") {
				dept.setName(search);
			}
			dept.setState(mConst.STATE_T);
			Page<Dept> list = deptService.findByPage(dept);
			rm.success().page(list);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("fail");
		}
		return rm;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public ResultMap getName() {
		ResultMap rm = new ResultMap();
		try {
			Dept dept = new Dept();
			dept.setId(null);
            dept.setState(mConst.STATE_T);
			List<Dept> list = deptService.list(dept);
			rm.success().data(list);
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("查询社团失败");
		}
		return rm;
		
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultMap update(Dept dept) {
		ResultMap rm = new ResultMap();
		try {
			deptService.update(dept);
			rm.success().info("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("修改失败");
		}
		return rm;
		
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultMap add(Dept dept) {
		ResultMap rm = new ResultMap();
		try {
			dept.setState(mConst.STATE_T);
			deptService.add(dept);
			rm.success().info("增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("增加失败");
		}
		return rm;
		
	}
	
	@RequestMapping("remove")
	@ResponseBody
	public ResultMap remove(Dept dept) {
		ResultMap rm = new ResultMap();
		try {
			dept.setState(mConst.STATE_F);
			deptService.update(dept);
			rm.success().info("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			rm.fail().info("删除失败");
		}
		return rm;
		
	}
	
	@RequestMapping("check")
	@ResponseBody
	public Boolean check(Dept dept) {
		try {
			Dept dp = deptService.check(dept);
			if(dp!=null) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return true;
		
	}
}
