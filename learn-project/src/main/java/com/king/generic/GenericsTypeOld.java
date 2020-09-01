package com.king.generic;

import lombok.Data;

/**
 * java 6 ?
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-06-15 10:18:30
 */
 @Data
public class GenericsTypeOld {

    private Object object;

    public static void main(String[] args) {
        GenericsTypeOld genericsTypeOld = new GenericsTypeOld();
        genericsTypeOld.setObject("Pankaj");
        String string = (String) genericsTypeOld.getObject(); // type casting, error prone and can cause ClassCastException
    }

}
