package com.jeff.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.mapper.IntervieweeMapper;
import com.jeff.mybatis.page.Page;
import com.jeff.po.Form;
import com.jeff.po.Interviewee;
import com.jeff.service.IntervieweeService;


@Service
public class IntervieweeServiceImpl extends BaseServiceImpl<Interviewee, String>implements IntervieweeService {

	@Autowired
	private IntervieweeMapper intervieweeMapper;

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(intervieweeMapper);
	}

	@Override
	public Page<Interviewee> selecteeByformIdByPage(Form form) {
		return this.buildPage(intervieweeMapper.selecteeByformIdByPage(form));//封装成Page对象
	}


}
