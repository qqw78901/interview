package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.DeptMapper;
import com.jeff.po.Dept;
import com.jeff.service.DeptService;


@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept, String>implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(deptMapper);
	}

	@Override
	public Dept check(Dept dept) {
		return deptMapper.check(dept);
	}

}
