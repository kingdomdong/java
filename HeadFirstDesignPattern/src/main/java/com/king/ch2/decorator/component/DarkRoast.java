package com.king.ch2.decorator.component;

import com.king.ch2.decorator.abstraction.Beverage;
import com.king.ch2.decorator.po.Size;

/**
 * dark roast coffee beverage
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-03-01 20:18:13
 */
public class DarkRoast extends Beverage {

    public DarkRoast(Size size) {
        setDescription("DarkRoast");
        setSize(size);
    }

    @Override
    public double cost() {
        return 0.99;
    }

}
