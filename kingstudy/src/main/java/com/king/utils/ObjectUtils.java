/**
 * Copyright &copy; 2012-2016 <a href="https://www.znv.com">ZNV</a> All rights reserved.
 */
package com.king.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象操作工具类
 * @author XuBin
 * @version 2014-6-29
 */
public class ObjectUtils {
    
    @SuppressWarnings("unchecked")
    public static Map<String, Object> toParamMap(Object obj) {
        if (obj instanceof Map) {
            return (Map<String, Object>) obj;
        }

        Map<String, Object> proMap = new HashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) != null) {
                        proMap.put(field.getName(), field.get(obj));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            clazz = clazz.getSuperclass();
        }

        return proMap;
    }

    public static <T> T toObject(Class<T> clazz, Map<String, String> fields) {
        T obj = null;
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
            obj = clazz.newInstance();
            // 遍历属性列表，查找指定的属性  
            if (proDescrtptors != null && proDescrtptors.length > 0) {
                for (PropertyDescriptor propDesc : proDescrtptors) {
                    // 找到则写入属性值 
                    if (fields.containsKey(propDesc.getName())) {
                        Method writeMethod = propDesc.getWriteMethod();
                        writeMethod.invoke(obj, fields.get(propDesc.getName()));  // 写入属性值  
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("toObject failed, " + e.toString());
        }

        return obj;
    }
}
