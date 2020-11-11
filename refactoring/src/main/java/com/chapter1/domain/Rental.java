package com.chapter1.domain;

import lombok.Data;

/**
 * pure data
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-07-14 22:12:40
 */
@Data
public class Rental {
    private Movie movie;
    private int daysRented;
}
