package com.king.reflect;

/**
 * common class for reflection
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-13 16:12:45
 */
public class CommonPrintClass {

    private String string;

    public CommonPrintClass() {
        string = "GeeksforGeeks";
    }

    public void method1() {
        System.out.println("The string is " + string);
    }

    public void method2(int n) {
        System.out.println("The number is " + n);
    }

    private void method3() {
        System.out.println("Private method invoked");
    }

}
