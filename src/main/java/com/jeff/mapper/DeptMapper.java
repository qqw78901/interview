package com.jeff.mapper;

import org.springframework.stereotype.Repository;

import com.jeff.po.Dept;

@Repository
public interface DeptMapper extends BaseMapper<Dept, String> {
	Dept check(Dept dept);

}
