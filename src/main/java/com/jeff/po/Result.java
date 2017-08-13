package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Result implements Serializable {

	private int id;//自增
	private String interviewId;// 某轮面试
	private String result;// T过F不过null无结果
	private String interviewee;// 面试者id
	private String state;

	public Result() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(String interviewee) {
		this.interviewee = interviewee;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
