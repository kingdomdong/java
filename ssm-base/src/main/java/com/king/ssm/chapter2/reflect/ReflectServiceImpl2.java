package com.king.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {

	private String name;

	public ReflectServiceImpl2(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Hello " + name);
	}

	public static ReflectServiceImpl2 getInstance(String param) {
		ReflectServiceImpl2 objImpl2 = null;
		try {
			objImpl2 = (ReflectServiceImpl2) Class
					.forName(ReflectServiceImpl2.class.getName())
					.getConstructor(String.class).newInstance(param);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return objImpl2;
	}

}
