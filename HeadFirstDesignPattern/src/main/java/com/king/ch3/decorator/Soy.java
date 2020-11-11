package com.king.ch3.decorator;

import com.king.ch3.decorator.abstraction.Beverage;
import com.king.ch3.decorator.abstraction.CondimentDecorator;
import com.king.ch3.decorator.po.Size;

/**
 * soy condiment decorator
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-03-01 21:00:06
 */
public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        if (Size.TALL == beverage.getSize())
            return .10 + beverage.cost();
        else if (Size.GRANDE == beverage.getSize())
            return .15 + beverage.cost();
        else if (Size.VENTI == beverage.getSize())
            return .20 + beverage.cost();

        return beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

}
