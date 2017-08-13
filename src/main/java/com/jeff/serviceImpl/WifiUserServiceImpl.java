package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.WifiUserMapper;
import com.jeff.po.WifiUser;
import com.jeff.service.WifiUserService;


@Service
public class WifiUserServiceImpl extends BaseServiceImpl<WifiUser, String>implements WifiUserService {

	@Autowired
	private WifiUserMapper WifiUserMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(WifiUserMapper);
	}

	@Override
	public WifiUser login(WifiUser wifiUser) {
		return WifiUserMapper.login(wifiUser);
	}


}
