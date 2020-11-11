package com.king;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yum
 * @version 1.0
 * @since 2020-10-29 16:35:38
 */
public class Example {

    private static final String TYPE_1 = "type1";
    private static final String TYPE_2 = "type2";
    private static final String TYPE_3 = "type3";
    private static final String TYPE_4 = "type4";
    private static final String TYPE_5 = "type5";
    private static final String TYPE_6 = "type6";
    private static final String TYPE_7 = "type7";
    private static final double VALUE_1 = 0.1;
    private static final double VALUE_2 = 0.2;
    private static final double VALUE_3 = 0.3;
    private static final double VALUE_4 = 0.4;
    private static final double VALUE_5 = 0.5;
    private static final double VALUE_6 = 0.6;
    private static final double VALUE_7 = 0.7;

    Map<String, Double> map = new HashMap<>();

    public Example() {
        map.put(TYPE_1, VALUE_1);
        map.put(TYPE_2, VALUE_2);
        map.put(TYPE_3, VALUE_3);
        map.put(TYPE_4, VALUE_4);
        map.put(TYPE_5, VALUE_5);
        map.put(TYPE_6, VALUE_6);
        map.put(TYPE_7, VALUE_7);
    }

    public Double computeScore(String type, Double score, Double sum) {
        return map.entrySet().stream()
                .filter(entry -> entry.getKey().equals(type))
                .findFirst()
                .map(entry -> sum + score * entry.getValue())
                .orElse(sum);
    }

}
