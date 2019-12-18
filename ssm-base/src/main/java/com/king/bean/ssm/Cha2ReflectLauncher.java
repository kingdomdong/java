package com.king.bean.ssm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.king.bean.ssm.chapter2.reflect.ReflectServiceImpl;
import com.king.bean.ssm.chapter2.reflect.ReflectServiceImpl2;

public class Cha2ReflectLauncher {

	// reflect Class without parameter constructor
	public static ReflectServiceImpl getInstance(String classPath) {
		ReflectServiceImpl object = null;

		try {
			object = (ReflectServiceImpl) Class.forName(classPath).getConstructor().newInstance();
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException | ClassNotFoundException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}

		return object;
	}

	// reflect Class with String parameter constructor
	public static ReflectServiceImpl2 getInstance2() {
		ReflectServiceImpl2 objectImpl2 = null;

		try {
			objectImpl2 = (ReflectServiceImpl2) Class.forName("ssm.ReflectServiceImpl2").getConstructor(String.class)
					.newInstance("kingdomdong");
		} catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

		return objectImpl2;
	}

	// reflect method
	public static Object reflectMethod() {
		Object reflectMethod = null;
		
		ReflectServiceImpl targetServiceImpl = new ReflectServiceImpl();
		try {
			Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
			reflectMethod = method.invoke(targetServiceImpl, "張三");
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return reflectMethod;
	}

	// test reflect
	public static void main(String[] args) {
		ReflectServiceImpl serviceImpl = getInstance("ssm.ReflectServiceImpl");
		serviceImpl.sayHello("xinxin");

		ReflectServiceImpl2 serviceImpl2 = getInstance2();
		serviceImpl2.sayHello();
		
		reflectMethod();
	}

}
