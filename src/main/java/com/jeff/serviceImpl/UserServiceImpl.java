package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.UserMapper;
import com.jeff.po.User;
import com.jeff.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(userMapper);
	}

	@Override
	public User check(User user) {
		return userMapper.check(user);
	}

}
