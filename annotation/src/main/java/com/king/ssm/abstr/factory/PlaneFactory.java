package com.king.ssm.abstr.factory;

import com.king.ssm.abstr.factory.product.Airbus;
import com.king.ssm.abstr.factory.product.Boeing;
import com.king.ssm.factory.IProduct;
import com.king.ssm.factory.NoSupportedException;

public class PlaneFactory extends AbstractFactory implements IProductFactory {

	@Override
	public IProduct generateProduct(String proCode) {
		switch (proCode) {
		case "001":
			return new Airbus();
		case "002":
			return new Boeing();
		default:
			throw new NoSupportedException("Not support this Plane type.");
		}
	}

}
