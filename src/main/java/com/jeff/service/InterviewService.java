package com.jeff.service;

import com.jeff.mybatis.page.Page;
import com.jeff.po.Interview;

public interface InterviewService extends BaseService<Interview, String> {
	public Page<Interview> selectByPage(Interview interview);
	public int change(Interview interview);
	public int checkChild(Interview interview);
	public Interview getCurrent(Interview interview);
}
