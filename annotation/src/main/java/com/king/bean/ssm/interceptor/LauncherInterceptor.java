package com.king.bean.ssm.interceptor;

public class LauncherInterceptor {

	public static void testInterceptor() {
		// new proxy instance, in which interceptor will be reflected
		InterceptorJdkProxy interceptorJdkProxy = new InterceptorJdkProxy(new HelloWorldImpl(),
				"com.king.ssm.interceptor.InterceptorImpl");
		// generate proxy object
		HelloWorld helloWorldProxy = (HelloWorld) interceptorJdkProxy.bind();
		// invoke method
		helloWorldProxy.sayHello();
	}

	public static void main(String[] args) {
		testInterceptor();
	}

}
