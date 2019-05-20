package com.king.component.bean;

import org.springframework.stereotype.Component;

@Component
public class ComBean {

	private String username;
	private String url;
	private String password;
	
	public ComBean() {
		this.username = "xinxin";
		this.url = "http://www.xinxix.com";
		this.password = "******";
	}

	public void sayHello() {
		System.out.println("ComBean sayHello ...");
	}

	public String toString() {
		return "username:" + this.username + ", url:" + this.url + ", password:" + this.password;
	}

	public void start() {
		System.out.println("ComBean initialized.");
	}

	public void cleanUp() {
		System.out.println("ComBean destroyed.");
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
