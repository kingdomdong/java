package com.king.ssm.factory;

public class NoSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoSupportedException(String msg) {
		super(msg);
	}

}
