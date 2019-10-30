package com.king.bean.ssm.chapter2.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

	// real target
	private Object target = null;

	/**
	 * produce proxy object
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	/**
	 * proxy method
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("enter proxy method");
		System.out.println("server before handling real object HelloWorldImpl");
		// use reflection
		Object object = method.invoke(target, args);
		System.out.println("server after handling real object HelloWorldImpl");

		return object;
	}

}
