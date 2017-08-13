package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.InfoMapper;
import com.jeff.po.Info;
import com.jeff.service.InfoService;


@Service
public class InfoServiceImpl extends BaseServiceImpl<Info, String>implements InfoService {

	@Autowired
	private InfoMapper infoMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(infoMapper);
	}


}
