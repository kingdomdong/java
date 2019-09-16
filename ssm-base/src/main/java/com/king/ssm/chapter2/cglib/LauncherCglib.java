package com.king.ssm.chapter2.cglib;

import com.king.ssm.chapter2.reflect.ReflectServiceImpl;

public class LauncherCglib {
	
	public static void testCglibProxy() {
		CglibProxy cglibProxy = new CglibProxy();
		ReflectServiceImpl reflectProxy = (ReflectServiceImpl) cglibProxy.getProxy(ReflectServiceImpl.class); // generate proxy
		reflectProxy.sayHello("King");		
	}
	
	public static void main(String[] args) {
		testCglibProxy();
	}

}
