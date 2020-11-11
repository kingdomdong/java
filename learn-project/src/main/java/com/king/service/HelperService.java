package com.king.service;

import org.springframework.stereotype.Service;

@Service
public class HelperService {
    public IntNumber generateNumberB(IntNumber numberA) {
        return new IntNumber(-1);
    }
}
