package com.jeff.service;

import com.jeff.po.Admin;
import com.jeff.vo.AdminLoginVo;

public interface AdminService extends BaseService<Admin, String> {
	public Admin login(AdminLoginVo adminLoginVo);

	public int changePassword(Admin admin);
}
