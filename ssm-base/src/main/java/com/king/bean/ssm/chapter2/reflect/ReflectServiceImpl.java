package com.king.bean.ssm.chapter2.reflect;

/**
 * java.lang.reflect.*
 * 
 * @author 0049002907
 *
 */
public class ReflectServiceImpl {

	public void sayHello(String name) {
		System.out.println("Hello");
	}

	public static ReflectServiceImpl getInstance() {
		ReflectServiceImpl objectImpl = null;
		try {
			objectImpl = (ReflectServiceImpl) Class.forName(ReflectServiceImpl.class.getName())
					.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return objectImpl;
	}

}
