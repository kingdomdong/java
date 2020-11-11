package com.king.generic;

import lombok.Getter;

/**
 * bounded type parameter
 * used with methods, classes, interfaces
 *
 * multiple bounds:
 * <T extends A, B, C> - no more than one class here and A can be a class
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-06-15 12:08:41
 */
@Getter
public class GenericBoundedTypeParam implements Comparable<GenericBoundedTypeParam> {

    private String name;

    public GenericBoundedTypeParam(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(GenericBoundedTypeParam typeParam) {
        return name.compareTo(typeParam.getName());
    }

    // restrict the type of objects that can be used in the parameterized type - bounded type parameter
    public static <T extends Comparable<T>> int compare(T fir, T sec) {
        return fir.compareTo(sec);
    }

    // multiple bounds
    public static <T extends GenericBoundedTypeParam & Comparable<GenericBoundedTypeParam> & Cloneable> int multiBound(T fir, T sec) {
        try {
            sec = (T) fir.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return fir.compareTo(sec);
    }

    public void test(String[] args) {
        GenericBoundedTypeParam typeParam = new GenericBoundedTypeParam("xyz");
        GenericBoundedTypeParam typeParam1 = new GenericBoundedTypeParam("abc");

        int compare = GenericBoundedTypeParam.compare(typeParam, typeParam1);
        System.out.println(compare);
    }

}
