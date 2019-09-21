package com.king.ssm.chapter2.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	/**
	 * generate cglib proxy-object
	 * @param clz
	 * @return
	 */
	public Object getProxy(Class<? extends Object> clz) {
		// CGLIB Enhancer
		Enhancer enhancer = new Enhancer();
		// setup enhancer
		enhancer.setSuperclass(clz);
		// set proxy object to this object which must implement MethodInterceptor
		enhancer.setCallback(this);
		// create and return proxy-object
		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("invoke before real Object.");
		// CGLIB invoke real Object by reflect;
		// methodProxy.invoke() will cause infinite loop (endless loop)
		Object result = methodProxy.invokeSuper(proxy, args);
		System.out.println("invoke after real Object");
		return result;
	}

}
