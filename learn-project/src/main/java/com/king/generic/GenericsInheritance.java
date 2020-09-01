package com.king.generic;

/**
 *
 * @author kingdomdong
 * @since 
 * @version 1.0
 */
public class GenericsInheritance {

    public static void main(String[] args) {
        String str = "abc";
        Object obj = new Object();
        obj = str; // works because String is-a Object, inheritance in Java

        GenericsType<String> type = new GenericsType<>();
        GenericsType<Object> objectGenericsType = new GenericsType<>();
//        objectGenericsType = type; // compilation error since GenericsType<String> is not a GenericsType<Object>
        obj = type; // GenericsType<String> is Object
    }

}
