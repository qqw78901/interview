package com.jeff.vo;

import java.io.Serializable;

import com.jeff.po.BasePo;
@SuppressWarnings("serial")
public class CheckinVo extends BasePo implements Serializable{
	
	private String mac;
	private String assid;
	private String ssid;
	private String userId;
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getAssid() {
		return assid;
	}
	public void setAssid(String assid) {
		this.assid = assid;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public CheckinVo() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
