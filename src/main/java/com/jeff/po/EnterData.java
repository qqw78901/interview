package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EnterData implements Serializable {

	private int id;//自增
	private int thId;//表头id
	private String interviewee;//面试者id
	private String text;//内容

	public EnterData() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThId() {
		return thId;
	}

	public void setThId(int thId) {
		this.thId = thId;
	}

	public String getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(String interviewee) {
		this.interviewee = interviewee;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



}
