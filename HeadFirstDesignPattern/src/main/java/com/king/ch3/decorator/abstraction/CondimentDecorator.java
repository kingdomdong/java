package com.king.ch3.decorator.abstraction;

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
