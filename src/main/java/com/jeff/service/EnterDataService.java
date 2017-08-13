package com.jeff.service;

import java.util.List;

import com.jeff.po.EnterData;
import com.jeff.vo.EnterDataVo;


public interface EnterDataService extends BaseService<EnterData, String> {
	public int batchEntry(List<EnterData> enterDatas);
	List<EnterDataVo> getByIntervieweeId(String intervieweeId);
}
