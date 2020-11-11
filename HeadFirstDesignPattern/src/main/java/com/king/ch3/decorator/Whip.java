package com.king.ch3.decorator;

import com.king.ch3.decorator.abstraction.Beverage;
import com.king.ch3.decorator.abstraction.CondimentDecorator;

/**
 * whip condiment decorator
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-03-01 21:01:58
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

}
