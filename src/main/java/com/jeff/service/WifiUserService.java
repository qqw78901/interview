package com.jeff.service;

import com.jeff.po.WifiUser;

public interface WifiUserService extends BaseService<WifiUser, String> {
	public WifiUser login(WifiUser wifiUser);
	
}
