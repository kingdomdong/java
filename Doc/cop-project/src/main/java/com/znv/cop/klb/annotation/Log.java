package com.znv.cop.klb.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.znv.cop.klb.annotation.logenum.LogType;

/**
 * 记录日志注解
 * @author xubin
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 日志类型
	 * @return
	 */
	LogType type() default LogType.BusinessActionLog ;
	
	/**
	 * 请求地址
	 * @return
	 */
	String  url()  default "" ; 
	
	/**
	 * 处理节点
	 * @return
	 */
	String action() default "" ;
	
	/**
	 * 处理目标
	 * @return
	 */
	String target() default "" ;
	
}
