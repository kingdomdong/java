package com.king.bean.ssm.chapter2.interceptor;

import java.lang.reflect.Method;

public class InterceptorImpl implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("invocation before real method executed");
		return false; // not reflect real method
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("replace the real method execution");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("invocation after real mehtod executed");
	}

}
