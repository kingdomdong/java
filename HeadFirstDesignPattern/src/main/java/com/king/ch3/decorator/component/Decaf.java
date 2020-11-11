package com.king.ch3.decorator.component;

import com.king.ch3.decorator.abstraction.Beverage;
import com.king.ch3.decorator.po.Size;

/**
 * decaffeinated coffee beverage
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-03-01 20:18:49
 */
public class Decaf extends Beverage {

    public Decaf(Size size) {
        setDescription("Decaffeinated Coffee");
        setSize(size);
    }

    @Override
    public double cost() {
        return 1.05;
    }

}
