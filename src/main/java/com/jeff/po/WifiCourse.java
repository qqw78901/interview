package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WifiCourse extends BasePo implements Serializable {
	private String isPublic;//T/F
	private String userId;//
	private String ssid;// 
	private String mac;
	private String state;
	

	public String getIsPublic() {
		return isPublic;
	}




	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getSsid() {
		return ssid;
	}




	public void setSsid(String ssid) {
		this.ssid = ssid;
	}






	


	public WifiCourse() {
		super();
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getMac() {
		return mac;
	}




	public void setMac(String mac) {
		this.mac = mac;
	}


	
}
