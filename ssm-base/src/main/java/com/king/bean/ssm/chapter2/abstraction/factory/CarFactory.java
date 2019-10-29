package com.king.bean.ssm.chapter2.abstraction.factory;

import com.king.ssm.abstr.factory.product.Nissan;
import com.king.ssm.abstr.factory.product.Toyota;
import com.king.bean.ssm.chapter2.factory.IProduct;
import com.king.ssm.factory.IProduct;
import com.king.ssm.factory.NoSupportedException;

public class CarFactory implements IProductFactory {

	@Override
	public IProduct generateProduct(String proCode) {
		switch (proCode) {
		case "001":
			return new Nissan();
		case "002":
			return new Toyota();
		default:
			throw new NoSupportedException("Not support this Car type: " + proCode);
		}
	}

}