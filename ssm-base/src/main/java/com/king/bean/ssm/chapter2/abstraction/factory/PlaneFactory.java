package com.king.bean.ssm.chapter2.abstraction.factory;

import com.king.bean.ssm.chapter2.abstraction.product.Airbus;
import com.king.bean.ssm.chapter2.abstraction.product.Boeing;
import com.king.bean.ssm.chapter2.factory.IProduct;
import com.king.bean.ssm.chapter2.factory.NoSupportedException;

public class PlaneFactory extends AbstractFactory implements IProductFactory {

    @Override
    public IProduct generateProduct(String proCode) {
        switch (proCode) {
            case "001":
                return new Airbus();
            case "002":
                return new Boeing();
            default:
                throw new NoSupportedException("Not support this Plane type: " + proCode);
        }
    }

}
