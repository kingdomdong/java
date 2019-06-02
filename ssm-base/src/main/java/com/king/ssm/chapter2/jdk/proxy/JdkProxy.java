package com.king.ssm.chapter2.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
	
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

	@Override
	public Object invoke(Object proxy, Method method, Object[
	                                                         ] args) throws Throwable {
		System.out.println("進入代理前的方法");
		System.out.println("server before handling real object HelloWorldImpl");
		Object object = method.invoke(target, args);
		System.out.println("server after handling real object HelloWorldImpl");
		
		return object;
	}

}
