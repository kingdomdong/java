package com.king.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayTest {

    @Test
    void stringArray() {
        String[] array = new String[0];
        for(int i = 0; i < array.length; i += 2) {
            System.out.println(array[i+1] + " ,i = " + i);
        }
        Arrays.stream(array).forEach(item -> System.out.println(item));
    }

}