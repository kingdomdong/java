package com.king.ch3.decorator.component;

import com.king.ch3.decorator.abstraction.Beverage;
import com.king.ch3.decorator.po.Size;

/**
 * concrete component 综合咖啡
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-02-29
 */
public class HouseBlend extends Beverage {

    public HouseBlend(Size size) {
        setDescription("House Blend Coffee");
        setSize(size);
    }

    @Override
    public double cost() {
        return 0.89;
    }

}
