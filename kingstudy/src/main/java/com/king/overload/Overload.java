package com.king.overload;

public class Overload {
    
    public static void main(String[] args) {
        Double a = Double.parseDouble("12");
        System.err.println(a.intValue());

        overload();
        overload(1);
    }

    public static void overload() {
        System.out.println("call overtload('default value -1')");
        overload(-1);
    }

    public static void overload(int a) {
        System.out.println("overload parameter: " + a);
    }

}
