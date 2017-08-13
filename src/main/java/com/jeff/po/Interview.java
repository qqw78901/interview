package com.jeff.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Interview extends BasePo implements Serializable {

	private String followBy;
	/*private Date startTime;
	private Date endTime;*/
	private String deptId;
	private String title;
	private String isPublic;
	private String state;
	private String path;//路径

	public Interview() {
		super();
	}


/*	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}*/

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}


	public String getFollowBy() {
		return followBy;
	}


	public void setFollowBy(String followBy) {
		this.followBy = followBy;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


}
