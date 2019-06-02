package com.king.ssm.chapter2.jdk.proxy;

public class LaunchProxy {
	
	public static void testJdkProxy() {
		JdkProxy jdkProxy = new JdkProxy();
		
		// bind Class object, helloWorldProxy will call invoke()
		HelloWorld helloWorldProxy = (HelloWorld) jdkProxy.bind(new HelloWorldImpl());
		
		helloWorldProxy.sayHelloWorld();
	}
	
	public static void main(String[] args) {
		testJdkProxy();
	}

}
