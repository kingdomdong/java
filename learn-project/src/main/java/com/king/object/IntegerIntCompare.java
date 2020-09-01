package com.king.object;

/**
 * equals & ==
 * @author kingdomdong
 * @since 2020-04-24 10:03:59
 * @version 1.0
 */
public class IntegerIntCompare {

    public static void main(String[] args) {
        // output:
        // true
        Integer notNullInteger = Integer.valueOf("2");
        int j = 2;
        System.out.println(notNullInteger == j);

        // java.lang.NullPointerException
        // unboxing integer may produce "NullPointerException"
        // can convert wrapper to primitive

        // Before:
        Integer integer = 1;
        int i = 1;
        System.out.println(integer == i);

        // After:
        int origin = Math.subtractExact(2, 1); // Returns the difference of the arguments, throwing an exception if the result overflows an int.
        int destination = 1;
        System.out.println(origin == destination);
    }

}
