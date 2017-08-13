package com.jeff.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.jeff.po.BasePo;
import com.jeff.po.FormTh;

@SuppressWarnings("serial")
public class FormShowVo extends BasePo implements Serializable {

	private String title;//表单名称
	private String ps;//描述
	private String deptName;//创建社团
	private String interview;//面试名称
	private String interviewId;//面试id
	private Date startTime;//开始报名时间
	private Date endTime;//结束报名时间
	private String timeLimit;//是否限制报名时间 T/F
	private List<FormTh> elements;//报名内容

	public FormShowVo() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public List<FormTh> getElements() {
		return elements;
	}

	public void setElements(List<FormTh> elements) {
		this.elements = elements;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getInterview() {
		return interview;
	}

	public void setInterview(String interview) {
		this.interview = interview;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}




}
