package com.king.bean.ssm.pojo;

import com.king.bean.ssm.enumeration.SexEnum;

public class User {

	/**
	 *
	 */
	private String id;

	/**
	 *
	 */
	private String userName;

	/**
	 *
	 */
	private String password;

	/**
	 *
	 */
	private SexEnum sex;

	/**
	 *
	 */
	private String mobile;

	/**
	 *
	 */
	private String tel;

	/**
	 *
	 */
	private String email;

	/**
	 *
	 */
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}