package com.jeff.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EnterDataVo implements Serializable {

	private int id;//自增
	private int thId;//表头id
	private String interviewee;//面试者id
	private String text;//内容
	private String name;//表头名称
	private String orderby;//排序 1 2 3 4 
	private String formId;//表单id
	private String type;//表头类型(text,radio,checkbox)
	private String typeText;//radio或checkbox之类的内容
	private String required;//是否必填

	public EnterDataVo() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}



}
