package com.chapter1.domain;

import lombok.Data;

/**
 * Movie pure data class
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-07-14 07:03:43
 */
@Data
public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;
    private int priceCode;
    private String title;

}
