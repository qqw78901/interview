package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.AdminMapper;
import com.jeff.po.Admin;
import com.jeff.service.AdminService;
import com.jeff.vo.AdminLoginVo;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, String> implements
		AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(adminMapper);
	}

	@Override
	public Admin login(AdminLoginVo adminLoginVo) {
		Admin admin = adminMapper.login(adminLoginVo);
		return admin;
	}

	@Override
	public int changePassword(Admin admin) {
		return adminMapper.changePassword(admin);
	}
}
