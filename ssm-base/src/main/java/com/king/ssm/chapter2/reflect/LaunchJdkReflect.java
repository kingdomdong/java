package com.king.ssm.chapter2.reflect;

/**
 * launch jdk reflection
 * 
 * @author 0049002907
 *
 */
public class LaunchJdkReflect {

	public static void main(String[] args) {
		// object jdk reflect
		ReflectServiceImpl objectImpl = ReflectServiceImpl.getInstance();
		objectImpl.sayHello();

		ReflectServiceImpl2 objeImpl2 = ReflectServiceImpl2.getInstance("Xin");
		objeImpl2.sayHello();
	}

}
