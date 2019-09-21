package com.znv.cop.klb.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONUtils {

	/**
	 * 将对象转化成json字符串
	 * @param o
	 * @return
	 */
	public static String objectToJsonString(Object o){
		return JSON.toJSONString(o,SerializerFeature.WriteNullStringAsEmpty) ;
	}
	
	/**
	 * 将json字符串转化成对象
	 * @param str
	 * @return
	 */
	public static Object jsonStringToObject(String str){
		return JSON.parse(str) ;
	}
	
	
}
