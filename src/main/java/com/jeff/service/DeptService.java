package com.jeff.service;

import com.jeff.po.Dept;

public interface DeptService extends BaseService<Dept, String> {
	public Dept check(Dept dept);
}
