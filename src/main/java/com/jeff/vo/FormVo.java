package com.jeff.vo;

import java.io.Serializable;
import java.util.Date;

import com.jeff.po.BasePo;
@SuppressWarnings("serial")
public class FormVo extends BasePo implements Serializable{
	
	private String title; //表单名称
	private String name; //面试名
	private String deptName; //社团名
	private String timeLimit;   //是否被限制
	private Date startTime;   //开始时间
	private Date endTime;   //结束时间
	private String state;
	
	
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
