package com.king.ch2.decorator;

import com.king.ch2.decorator.abstraction.Beverage;
import com.king.ch2.decorator.abstraction.CondimentDecorator;

/**
 * milk condiment decorator
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-03-01 21:03:55
 */
public class Milk extends CondimentDecorator {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

}
