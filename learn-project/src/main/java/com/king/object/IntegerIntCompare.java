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
        Integer notNullInter = Integer.valueOf("a");
        int j = 2;
        System.out.println(notNullInter == j);

        // java.lang.NullPointerException
        // unboxing integer may produce "NullPointerException"
        // can convert wrapper to primitive

        // Before:
        Integer integer = 1;
        int i = 1;
        System.out.println(integer == i);

        // After:
        int origin = Math.subtractExact(1, 2);
        int destination = 1;
        System.out.println(origin == destination);
    }

}
