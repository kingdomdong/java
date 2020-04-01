package com.king.crc;

import java.util.Arrays;
import java.util.List;

public class CcittRule {

    private final static Integer cPoly = 0x1021;

    static Integer generate(List<Integer> data) {
        Integer crcIn = 0xFFFF;
        Integer factor = 0;

        for (int i = 0; i < data.size(); i++) {
            Integer elem = data.get(i);
            crcIn ^= (factor << 8); // 移位 + 异或

            /**
             * // TODO
             */

            for (int j = 0; j < 8; j++) {
                if ((crcIn & 0x8000) > 0) {
                    crcIn = (crcIn << 1) ^ cPoly; // 移位 + 异或
                } else {
                    crcIn <<= 1;
                }
            }
        }

        return crcIn;
    }

    public static void main(String[] args) {
        System.out.println(generate(Arrays.asList(1, 2, 3)));
        char c = 'a';
        c <<= 2;

        int i = 97;
        i <<= 2;
        System.out.println(c + " " + i);
    }

}
