package com.king.generic;

/**
 * Sometimes we don't want the whole class to be parameterized, in that case, we can create java generics method, including Constructor
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-06-15 11:18:54
 */
public class GenericsMethods {

    // java Generic Method
    public static <T> boolean isEqual(GenericsType<T> first, GenericsType<T> second) {
        return first.getObject().equals(second.getObject());
    }

    public static void main(String[] args) {
        GenericsType<String> first = new GenericsType<>("Pankaj");
        GenericsType<String> second = new GenericsType<>("Pankaj");
        boolean isEqual = GenericsMethods.<String>isEqual(first, second);
//        above statement can be written simply as
        isEqual = GenericsMethods.isEqual(first, second);
//        This feature, known as TYPE INFERENCE, allows you to invoke a generic method as an ordinary method,
//        without specifying a type between angle brackets.
//        Compiler will infer the type that is needed
        System.out.println(isEqual);
    }

}
