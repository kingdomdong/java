package com.king.ch3.decorator.component;

import com.king.ch3.decorator.abstraction.Beverage;
import com.king.ch3.decorator.po.Size;

/**
 * concrete component 浓缩咖啡
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-02-29
 */
public class Espresso extends Beverage {

    public Espresso(Size size) {
        setDescription("Espresso");
        setSize(size);
    }

    public double cost() {
        return 1.99;
    }

}
