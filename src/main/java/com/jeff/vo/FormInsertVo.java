package com.jeff.vo;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.jeff.common.mConst;
import com.jeff.po.BasePo;
import com.jeff.po.Form;
import com.jeff.po.FormTh;
import com.jeff.util.DateUtil;

@SuppressWarnings("serial")
public class FormInsertVo extends BasePo implements Serializable {

	private String title;//表单名称
	private String ps;//描述
	private String deptId;//创建社团
	private String interview;//面试名称
	private String interviewId;//面试id
	private String startTime;//开始报名时间
	private String endTime;//结束报名时间
	private String timeLimit;//是否限制报名时间 T/F
	private List<FormTh> elements;//报名内容

	private Form form;
	
	public FormInsertVo() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public List<FormTh> getElements() {
		for(FormTh item:elements){
			item.setFormId(form.getId());
		}
		return elements;
	}

	public void setElements(List<FormTh> elements) {
		this.elements = elements;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Form getForm() {
		form = new Form();
		form.setId(UUID.randomUUID().toString());
		form.setInterviewId(this.getInterviewId());
		form.setPs(this.getPs());
		form.setTimeLimit(this.getTimeLimit());
		form.setTitle(this.getTitle());
		form.setStartTime(DateUtil.smartFormat(this.getStartTime()));
		form.setEndTime(DateUtil.smartFormat(this.getEndTime()));
		form.setDeptId(this.getDeptId());
		form.setState(mConst.STATE_T);
		return form;
	}

	public List<FormTh> getFormth() {
		return getElements();
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}




}
