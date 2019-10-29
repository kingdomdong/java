package com.king.bean.ssm.abstr.factory;

import com.king.bean.ssm.abstr.factory.product.Airbus;
import com.king.bean.ssm.abstr.factory.product.Boeing;
import com.king.bean.ssm.factory.IProduct;
import com.king.bean.ssm.factory.NoSupportedException;

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
