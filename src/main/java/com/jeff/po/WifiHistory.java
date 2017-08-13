package com.jeff.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class WifiHistory extends BasePo implements Serializable {

	private String mac;// 学生的mac地址
	private String createId;
	private Date createDt;
	private String createIp;
	private String courseId;
	private String state;


	public String getMac() {
		return mac;
	}



	public void setMac(String mac) {
		this.mac = mac;
	}



	public String getCreateId() {
		return createId;
	}



	public void setCreateId(String createId) {
		this.createId = createId;
	}



	public Date getCreateDt() {
		return createDt;
	}



	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}



	public String getCreateIp() {
		return createIp;
	}



	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}



	public String getCourseId() {
		return courseId;
	}



	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}



	public WifiHistory() {
		super();
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}

	
}
