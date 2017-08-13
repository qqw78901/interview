package com.jeff.mapper;

import org.springframework.stereotype.Repository;

import com.jeff.po.WifiUser;

@Repository
public interface WifiUserMapper extends BaseMapper<WifiUser, String> {
	WifiUser login(WifiUser wifiUser);
	

}
