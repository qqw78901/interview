package com.jeff.po;

import java.io.Serializable;
import java.lang.reflect.Field;

@SuppressWarnings("serial")
public class User extends BasePo implements Serializable {

	public static void main(String[] args) {
		Field[] fields = User.class.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
	private String name;// 姓名
	private String state;// 状态：有效、无效
	private String deptId;// 所在社团id
	private String gradeId;// 1超管2社团负责人3次要负责人
	private String card;// 学号
	private String loginName;// 账号
	private String password;// 密码
	private String sex;// 性别
	private String phone;// 电话


	public User() {
		super();
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


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getGradeId() {
		return gradeId;
	}


	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}


	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
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

}
