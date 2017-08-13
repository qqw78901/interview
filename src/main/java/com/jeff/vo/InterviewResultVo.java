package com.jeff.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class InterviewResultVo implements Serializable{
	public String id, name, card, phone, result;
	public List<EnterRowVo> enterRows;
	
	public InterviewResultVo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<EnterRowVo> getEnterRows() {
		return enterRows;
	}

	public void setEnterRows(List<EnterRowVo> enterRows) {
		this.enterRows = enterRows;
	}

}
