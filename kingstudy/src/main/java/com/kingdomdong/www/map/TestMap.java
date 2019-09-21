package com.kingdomdong.www.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestMap {
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(null, 0);
        map.put("java", 1);
        map.put("c++", 2);
        map.put("python", 3);
        map.put("php", 4);
        map.put("nodejs", 5);
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("php".hashCode() == "c++".hashCode());
    }

}
