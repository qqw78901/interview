package com.jeff.mapper;

import java.util.List;

import com.jeff.vo.EnterDataVo;
import org.springframework.stereotype.Repository;

import com.jeff.po.EnterData;

@Repository
public interface EnterDataMapper extends BaseMapper<EnterData, String> {
	int batchEntry(List<EnterData> enterDatas);
	List<EnterDataVo> getByIntervieweeId(String intervieweeId);
}
