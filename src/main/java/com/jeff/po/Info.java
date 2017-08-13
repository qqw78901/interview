package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Info extends BasePo implements Serializable {

	private String name;// 角色名称
	private String school;// 页面权限id，逗号分隔
	private String cla;// 方法权限id，逗号分隔
	private String psw;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public String getCla() {
		return cla;
	}


	public void setCla(String cla) {
		this.cla = cla;
	}


	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}
	


	public Info() {
		super();
	}

	
}
