package com.jeff.service;

import java.util.List;

import com.jeff.po.WifiHistory;
import com.jeff.vo.WifiHistoryVo;

public interface WifiHistoryService extends BaseService<WifiHistory, String> {
	public List<WifiHistoryVo> checked(WifiHistory wifiHistory);

	
}
