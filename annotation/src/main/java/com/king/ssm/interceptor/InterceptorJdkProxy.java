package com.king.ssm.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

	private Object target; // real object
	private String interceptorClass = null; // interceptor "path + class name"

	public InterceptorJdkProxy(Object target, String interceptorClass) {
		this.target = target;
		this.interceptorClass = interceptorClass;
	}

	/**
	 * generate new proxy object
	 * 
	 * @param target
	 * @param interceptorClass
	 * @return proxy object belongs to HelloWorld
	 */
	public Object bind() {
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (interceptorClass == null) {
			// not set interceptor and invoke real method immediately
			return method.invoke(proxy, args);
		}
		Object result = null;
		// ☆
		// generate interceptor by reflection
		Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).getConstructor().newInstance();

		// before
		if (interceptor.before(proxy, target, method, args)) {
			result = method.invoke(target, args);
		} else {
			interceptor.around(proxy, target, method, args);
		}

		// after
		interceptor.after(proxy, target, method, args);

		return result;
	}

}
