package com.king.service;

/**
 * @author Yum
 * @version 1.0
 * @since 2020-09-24 10:19:15
 */
public class SimpleCalculator {

    private IntNumber numberA;
    private IntNumber numberB;

    public SimpleCalculator(IntNumber numberA, IntNumber numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public int justDoIt(IntNumber numberA) {
        return numberA.add(numberB);
    }


    public int add() {
        return 0;
    }

    public int reduce() {
        return 0;
    }
}
