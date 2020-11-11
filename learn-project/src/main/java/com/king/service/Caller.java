package com.king.service;

import org.springframework.stereotype.Service;

@Service
public class Caller {

    private HelperService helperService;

    public Caller(HelperService helperService) {
        this.helperService = helperService;
    }

    public int justDoIt(IntNumber numberA) {
        SimpleCalculator calculator = new SimpleCalculator(numberA, numberA);

        return calculator.add() * calculator.reduce();
    }
}
