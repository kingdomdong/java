package com.king.reflect.network;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.util.Arrays.stream;

/**
 * a simple Java program to demonstrate the use of reflection
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-13 16:18:41
 */
public class ReflectionUsageDemo {
    private static CommonPrintClass commonPrintClass = new CommonPrintClass();

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<? extends CommonPrintClass> aClass = getThisClass();

        printClassName(aClass);
        printConstructorName(aClass);
        printMethodsNames(aClass);

        Method method1 = method1Invoked(aClass);
        method2Invoked(aClass);
        fieldChange(aClass, method1);
        privateMethod3Invoked(aClass);
    }

    /**
     * class fully qualified name
     * output:
     * com.king.reflect.CommonPrintClass
     */
    private static void printClassName(Class<? extends CommonPrintClass> aClass) {
        System.out.println("The name of class is " + aClass.getName());
    }

    /**
     * Constructor provides information about, and access to, a single constructor for a class.
     *
     * @param aClass
     * @throws NoSuchMethodException
     */
    private static void printConstructorName(Class<? extends CommonPrintClass> aClass) throws NoSuchMethodException {
        Constructor<? extends CommonPrintClass> constructor = aClass.getConstructor();
        System.out.println("The name of constructor is " + constructor.getName());
    }

    private static void printMethodsNames(Class<? extends CommonPrintClass> aClass) {
        Method[] methods = aClass.getMethods();
        stream(methods).map(Method::getName).forEach(System.out::println);
    }

    private static Method method1Invoked(Class<? extends CommonPrintClass> aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // returns a Method object that reflects the specified declared method of the class or interface represented bu this Class object.
        Method method1 = aClass.getDeclaredMethod("method1");
        // invoke the method at runtime
        method1.invoke(commonPrintClass);

        return method1;
    }

    /**
     * java.lang.Class is an entry of reflection
     *
     * @return
     */
    private static Class<? extends CommonPrintClass> getThisClass() {
        return commonPrintClass.getClass();
    }

    /**
     * Invokes the underlying method represented by this Method object, on the specified object with the specified parameters.
     *
     * @param aClass
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static void method2Invoked(Class<? extends CommonPrintClass> aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method2 = aClass.getDeclaredMethod("method2", int.class);
        method2.invoke(commonPrintClass, 19);
    }

    private static void fieldChange(Class<? extends CommonPrintClass> aClass, Method method1) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        // Return a Field object that reflects the specified declared field of the class or interface represented by this Class object.
        // If this Class object represents an array type, then this method does not find the length field of the array type.
        Field field = aClass.getDeclaredField("string");
        /*
         allows the object to access the field irrespective of the access specifier used with the field
         true:
         the reflected object should suppress Java language access checking when it is used.
         false:
         the reflected object should enforce Java language access checks.
         */
        field.setAccessible(true);
        field.set(commonPrintClass, "JAVA");
        method1.invoke(commonPrintClass);
    }

    private static void privateMethod3Invoked(Class<? extends CommonPrintClass> aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method3 = aClass.getDeclaredMethod("method3");
        method3.setAccessible(true);
        method3.invoke(commonPrintClass);
    }

}
