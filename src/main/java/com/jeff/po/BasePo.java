package com.jeff.po;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("serial")
// 基础字段
public class BasePo implements Serializable {

	/**
	 * id要为public的，如果是private的话，其它子类po无法访问这个id属性
	 */
	public String id;// uuid

/*	private String createId;
	private Date createDt;
	private String updateId;
	private Date updateDt;*/

	public BasePo() {
		super();
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
/*
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

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}*/

}
