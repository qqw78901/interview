package com.jeff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeff.po.WifiHistory;
import com.jeff.vo.WifiHistoryVo;

@Repository
public interface WifiHistoryMapper extends BaseMapper<WifiHistory, String> {
	List<WifiHistoryVo> checked(WifiHistory wifiHistory);

}
