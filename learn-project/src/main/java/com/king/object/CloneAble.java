package com.king.object;

/**
 * Object's clone() - must support the cloneable interface
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-06-08 19:05:28
 */
public class CloneAble implements Cloneable {

    private String value;

    public CloneAble(String value) {
        this.value = value;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneAble a = new CloneAble("value");
        CloneAble b = (CloneAble) a.clone();
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.getClass() == b.getClass());
    }

    public String getValue() {
        return value;
    }

}