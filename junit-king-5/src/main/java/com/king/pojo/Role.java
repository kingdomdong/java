package com.king.pojo;

import com.king.enumeration.SexEnum;

public class Role {

	private Integer id;

	private SexEnum sex;

	public Role() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

}
