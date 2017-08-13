package com.jeff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeff.po.Form;
import com.jeff.po.Interviewee;

@Repository
public interface IntervieweeMapper extends BaseMapper<Interviewee, String> {
	List<Interviewee> selecteeByformIdByPage(Form form);

}
