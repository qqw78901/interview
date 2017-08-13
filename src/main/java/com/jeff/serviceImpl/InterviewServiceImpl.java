package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.InterviewMapper;
import com.jeff.mybatis.page.Page;
import com.jeff.po.Interview;
import com.jeff.service.InterviewService;


@Service
public class InterviewServiceImpl extends BaseServiceImpl<Interview, String>implements InterviewService {

	@Autowired
	private InterviewMapper interviewMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(interviewMapper);
	}

	@Override
	public Page<Interview> selectByPage(Interview interview) {
		return this.buildPage(interviewMapper.selectByPage(interview));
	}

	@Override
	public int change(Interview interview) {
		return interviewMapper.change(interview);
	}

	@Override
	public int checkChild(Interview interview) {
		return interviewMapper.checkChild(interview);
	}

	@Override
	public Interview getCurrent(Interview interview) {
		return interviewMapper.getCurrent(interview);
	}
	



}
