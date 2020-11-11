package com.king.ch3.decorator.order;

import com.king.ch3.decorator.Mocha;
import com.king.ch3.decorator.Soy;
import com.king.ch3.decorator.Whip;
import com.king.ch3.decorator.abstraction.Beverage;
import com.king.ch3.decorator.component.DarkRoast;
import com.king.ch3.decorator.component.Espresso;
import com.king.ch3.decorator.component.HouseBlend;
import com.king.ch3.decorator.po.Size;

/**
 * order starbuzz coffee
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-03-01 21:09:32
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso(Size.GRANDE);
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast(Size.TALL);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend(Size.VENTI);
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }

}
