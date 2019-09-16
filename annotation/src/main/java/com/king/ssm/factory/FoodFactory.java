package com.king.ssm.factory;

import com.king.ssm.abstr.factory.IProductFactory;
import com.king.ssm.abstr.factory.product.Beans;
import com.king.ssm.abstr.factory.product.Cookie;
import com.king.ssm.abstr.factory.product.Cream;
import com.king.ssm.abstr.factory.product.Jelly;

public class FoodFactory implements IProductFactory {

	@Override
	public IProduct generateProduct(String proCode) {
		switch (proCode) {
		case "001":
			return new Cookie();
		case "002":
			return new Jelly();
		case "003":
			return new Beans();
		case "004":
			return new Cream();
		default:
			throw new NoSupportedException("Not support this Food type: " + proCode);
		}
	}

}
