package com.king.bean.ssm.chapter2.interceptor;

import java.lang.reflect.Method;

public interface Interceptor {
	
	/**
	 * invoke before real method executed
	 * @param proxy proxy object
	 * @param target real object
	 * @param method
	 * @param args
	 * @return
	 */
	public boolean before(Object proxy, Object target, Method method, Object[] args);
	
	public void around(Object proxy, Object target, Method method, Object[] args);
	
	public void after(Object proxy, Object target, Method method, Object[] args);

}
