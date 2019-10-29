package com.king.bean.ssm.abstr.factory;

import com.king.bean.ssm.factory.FoodFactory;
import com.king.bean.ssm.factory.IProduct;
import com.king.bean.ssm.factory.NoSupportedException;

public abstract class AbstractFactory implements IProductFactory {

	public static String filterProCode(String productNo) {
		return productNo.split("-")[1];
	}
	
	public static String filterProType(String productNo) {
		return productNo.split("-")[0];
	}
	
	public static IProduct generateIProduct(String productNo) {
		String proType = filterProType(productNo);
		IProductFactory factory = null;
		if ("Food".equals(proType)) {
			factory = new FoodFactory();
		} else if ("Car".equals(proType)) {
			factory = new CarFactory();
		} else if ("Plane".equals(proType)) {
			factory = new PlaneFactory();
		} else {
			throw new NoSupportedException("Not support this product type: " + proType);
		}
		
		String proCode = filterProCode(productNo);
		return factory.generateProduct(proCode);
	}

}
