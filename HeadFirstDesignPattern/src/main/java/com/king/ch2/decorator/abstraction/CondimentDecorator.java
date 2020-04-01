package com.king.ch2.decorator.abstraction;

import com.king.ch2.decorator.abstraction.Beverage;

/**
 * abstract decorator class
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-02-29
 */
public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();

}
