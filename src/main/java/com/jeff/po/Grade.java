package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Grade extends BasePo implements Serializable {

	private String name;// 角色名称
	private String pagePermitList;// 页面权限id，逗号分隔
	private String grade_id;// 方法权限id，逗号分隔

	public Grade() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPagePermitList() {
		return pagePermitList;
	}

	public void setPagePermitList(String pagePermitList) {
		this.pagePermitList = pagePermitList;
	}

	public String getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}

}
