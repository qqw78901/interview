package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FormTh implements Serializable {

	private int id;//自增
	private String name;//表头名称
	private String orderby;//排序 1 2 3 4 
	private String formId;//表单id
	private String type;//表头类型(text,radio,checkbox)
	private String required;//是否必填
	private String typeText;//radio或checkbox之类的内容
	private String state;
	private String isIndex;
	

	public String getIsIndex() {
		return isIndex;
	}


	public void setIsIndex(String isIndex) {
		this.isIndex = isIndex;
	}


	public FormTh() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getRequired() {
		return required;
	}


	public void setRequired(String required) {
		this.required = required;
	}
}
