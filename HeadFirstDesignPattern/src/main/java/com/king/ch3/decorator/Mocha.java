package com.king.ch2.decorator;

import com.king.ch2.decorator.abstraction.Beverage;
import com.king.ch2.decorator.abstraction.CondimentDecorator;

/**
 * mocha condiment decorator
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-03-01 20:56:53
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

}
