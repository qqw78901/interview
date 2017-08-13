package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WifiUser extends BasePo implements Serializable {

	private String name;// 用户
	private String loginName;
	private String type;// 用户类型
	private String mac;// 用户mac
	private String psw;//用户密码

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}
	


	public WifiUser() {
		super();
	}


	public String getMac() {
		return mac;
	}


	public void setMac(String mac) {
		this.mac = mac;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getloginName() {
		return loginName;
	}


	public void setloginName(String loginName) {
		this.loginName = loginName;
	}

	
}
