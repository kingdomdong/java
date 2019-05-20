package com.king.ssm.proxy;

public class LauncherCglib {
	
	public static void testCglibProxy() {
		CglibProxy cglibProxy = new CglibProxy();
		ReflectServiceImpl reflectProxy = (ReflectServiceImpl) cglibProxy.getProxy(ReflectServiceImpl.class); // generate proxy
		reflectProxy.sayHello();		
	}
	
	public static void main(String[] args) {
		testCglibProxy();
	}

}
