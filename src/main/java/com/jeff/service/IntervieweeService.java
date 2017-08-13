package com.jeff.service;

import com.jeff.mybatis.page.Page;
import com.jeff.po.Form;
import com.jeff.po.Interviewee;

public interface IntervieweeService extends BaseService<Interviewee, String> {
	public Page<Interviewee> selecteeByformIdByPage(Form form);

}
