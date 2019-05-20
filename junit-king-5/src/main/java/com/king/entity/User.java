package com.king.entity;

public class User {

	private String id;
	private String name;
	private Integer age;
	private String password;

	public User() {
	}

	public User(String name, String pwd) {
		this.name = name;
		this.password = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Object age) {
		if (age instanceof String) {
			throw new IllegalArgumentException("Age must be an Integer.");
		}
		this.age = (Integer)age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
