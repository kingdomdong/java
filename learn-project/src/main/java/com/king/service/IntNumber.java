package com.king.service;

public class IntNumber {

    private int value;

    public IntNumber(int value) {
        this.value = value;
    }

    public int add(IntNumber numberB) {
        return value + numberB.value;
    }

}
