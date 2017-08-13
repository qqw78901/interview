package com.jeff.mapper;

import org.springframework.stereotype.Repository;

import com.jeff.po.User;

@Repository
public interface UserMapper extends BaseMapper<User, String> {
	User check(User user);
}
