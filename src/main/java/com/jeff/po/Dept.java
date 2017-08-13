package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept extends BasePo implements Serializable {
	
	private String name;// 机构名称
	private String state;// 机构地址

	public Dept() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



}
