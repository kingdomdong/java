package com.king.ch3.decorator.abstraction;

import com.king.ch3.decorator.po.Size;
import lombok.Data;

/**
 * Abstract class of decorator
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-02-29
 */
@Data
public abstract class Beverage {

    private Size size;

    private String description = "Unknown Beverage";

    public abstract double cost();

}
