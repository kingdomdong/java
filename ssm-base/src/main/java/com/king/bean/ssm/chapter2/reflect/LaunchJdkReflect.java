package com.king.bean.ssm.chapter2.reflect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
		objectImpl.sayHello("xinxin");

		ReflectServiceImpl2 objeImpl2 = ReflectServiceImpl2.getInstance("Xin");
		objeImpl2.sayHello();

		List<Integer> list = Arrays.asList(1, 4, 5);
		
//		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
//		list.add(3);
//		list.add(4);
//		list.add(6);
//		list.add(5);
//		list.add(2);
		list.forEach(System.out::println);
		
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
//			if(1 == (Integer)iterator.next()) {
			iterator.next();
				iterator.remove();
//			}
		}

		list.forEach(System.out::println);
	}

}
