package com.king.bean.ssm.factory;

import com.king.bean.ssm.abstr.factory.IProductFactory;
import com.king.bean.ssm.abstr.factory.product.Beans;
import com.king.bean.ssm.abstr.factory.product.Cookie;
import com.king.bean.ssm.abstr.factory.product.Cream;
import com.king.bean.ssm.abstr.factory.product.Jelly;

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
