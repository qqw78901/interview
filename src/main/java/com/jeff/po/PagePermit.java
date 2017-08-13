package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PagePermit implements Serializable {

	private int id;
	private int parentId;// 父页面id
	private String name;// 页面名称
	private String url;// 页面url
	private String image;// 图标url

	public PagePermit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
