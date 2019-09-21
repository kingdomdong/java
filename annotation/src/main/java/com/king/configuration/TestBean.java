package com.king.configuration;

public class TestBean {

	private String username;
	private String url;
	private String password;
	
	public TestBean() {}

	public void sayHello() {
		System.out.println("TestBean sayHello ...");
	}

	public String toString() {
		return "username:" + this.username + ", url:" + this.url + ", password:" + this.password;
	}

	public void start() {
		System.out.println("TestBean initialized.");
	}

	public void cleanUp() {
		System.out.println("TestBean destroyed.");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
