package com.jeff.service;

import com.jeff.po.User;

public interface UserService extends BaseService<User, String> {
	public User check(User user);

}
