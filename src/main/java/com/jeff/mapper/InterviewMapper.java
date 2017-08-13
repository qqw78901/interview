package com.jeff.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeff.po.Interview;

@Repository
public interface InterviewMapper extends BaseMapper<Interview, String> {
	List<Interview> selectByPage(Interview interview);
	int change(Interview interview);
	int checkChild(Interview interview);
	String getChild(String id);
	Interview getCurrent(Interview interview);

}
