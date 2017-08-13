package com.jeff.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.EnterDataMapper;
import com.jeff.po.EnterData;
import com.jeff.service.EnterDataService;
import com.jeff.vo.EnterDataVo;

@Service
public class EnterDataServiceImpl extends BaseServiceImpl<EnterData, String> implements EnterDataService {

	@Autowired
	private EnterDataMapper enterDataMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(enterDataMapper);
	}

	@Override
	public int batchEntry(List<EnterData> enterDatas) {
		return enterDataMapper.batchEntry(enterDatas);
	}

	@Override
	public List<EnterDataVo> getByIntervieweeId(String intervieweeId) {
		return enterDataMapper.getByIntervieweeId(intervieweeId);
	}

}
