package com.jeff.po;

import java.io.Serializable;
import java.lang.reflect.Field;

@SuppressWarnings("serial")
public class Admin extends BasePo implements Serializable {

	public static void main(String[] args) {
		Field[] fields = Admin.class.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}

	private String deptId;// 社团id
	private String deptName;//社团名字
	private String loginName;// 登录名
	private String password;// 密码
	private String name;// 姓名
	private String sex;// 性别
	private String phone;// 电话
	private String state;// 状态：有效、无效
	private String address;// 地址
	private String gradeId;//1超管2社团负责人3次要负责人

	public Admin() {
		super();
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
