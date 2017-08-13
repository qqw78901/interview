package com.jeff.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.WifiHistoryMapper;
import com.jeff.po.WifiHistory;
import com.jeff.service.WifiHistoryService;
import com.jeff.vo.WifiHistoryVo;


@Service
public class WifiHistoryServiceImpl extends BaseServiceImpl<WifiHistory, String>implements WifiHistoryService {

	@Autowired
	private WifiHistoryMapper infoMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(infoMapper);
	}

	@Override
	public List<WifiHistoryVo> checked(WifiHistory wifiHistory) {
		return infoMapper.checked(wifiHistory);
	}


}
