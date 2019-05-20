package com.king.annotation;

public class AnnotationImpl {
    
    public static void main(String[] args) throws ClassNotFoundException {
        String CLASS_NAME = "com.king.annotation.Description_Test";
        Class<?> clz = Class.forName(CLASS_NAME);
        boolean flag = clz.isAnnotationPresent(Description.class);
        if (flag) {
            Description description = clz.getAnnotation(Description.class);
            System.out.println(description.value());
        }
    }
    
}
