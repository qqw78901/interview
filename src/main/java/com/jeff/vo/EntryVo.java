package com.jeff.vo;

import java.io.Serializable;
import java.util.List;

import com.jeff.po.EnterData;


@SuppressWarnings("serial")
public class EntryVo implements Serializable {

	private String name;
	private String card;
	private String phone;
	private String formId;
	private String interview;
	private List<EnterData> elements;

	public EntryVo() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<EnterData> getElements() {
		return elements;
	}

	public void setElements(List<EnterData> elements) {
		this.elements = elements;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getInterview() {
		return interview;
	}

	public void setInterview(String interview) {
		this.interview = interview;
	}


}
