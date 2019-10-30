package com.king.bean.ssm.chapter2.factory;

public class NoSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoSupportedException(String msg) {
		super(msg);
	}

}
