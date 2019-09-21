package com.king.ssm.main;

import com.king.ssm.chapter2.jdk.proxy.HelloWorld;
import com.king.ssm.chapter2.jdk.proxy.HelloWorldImpl;
import com.king.ssm.chapter2.jdk.proxy.JdkProxy;

public class Cha2ProxyLaunch {
	
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
