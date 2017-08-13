package com.jeff.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminLoginVo implements Serializable {

	private String loginName;// 登录名
	private String password;// 密码
	private String name;// 姓名
	private String state;// 状态：有效、无效

	public AdminLoginVo() {

	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
