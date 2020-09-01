package com.king.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Generics in Java
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-06-14 17:39:26
 */
public class TypeCheck {

    public static void main(String[] args) {
        comiperOKButCastException();
        correct();
    }

    private static void correct() {
        List<String> list = new ArrayList<>();
        list.add("abc");
//        list.add(new Integer(5)); // compiler error
        for (String elem : list) {
            System.out.println(elem);
        }
    }

    /**
     * java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
     */
    public static void comiperOKButCastException() {
        List list = new ArrayList<>();
        list.add("abc");
        list.add(new Integer(5));

        list.forEach(elem -> System.out.println((String) elem));
//        list.forEach(System.out::println); // will be fine, cause uses .toString()
    }


}
