package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Interviewee extends BasePo implements Serializable {
//面试者
	private String card;
	private String phone;
	private String state;
	private String name;

	public Interviewee() {
		super();
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




}
