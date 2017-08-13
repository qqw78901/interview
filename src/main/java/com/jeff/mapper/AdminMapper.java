package com.jeff.mapper;

import org.springframework.stereotype.Repository;

import com.jeff.po.Admin;
import com.jeff.vo.AdminLoginVo;

@Repository
public interface AdminMapper extends BaseMapper<Admin, String> {

	Admin login(AdminLoginVo adminLoginVo);
	
	int changePassword(Admin admin);
}
