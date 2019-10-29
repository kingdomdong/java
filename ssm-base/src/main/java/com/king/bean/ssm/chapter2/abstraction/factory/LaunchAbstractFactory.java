package com.king.bean.ssm.chapter2.abstraction.factory;

import com.king.ssm.factory.IProduct;

public class LaunchAbstractFactory {
	
	public static void main(String[] args) {
		IProduct product = AbstractFactory.generateIProduct("Food-004");
		System.out.println(product.getProductDesc());
	}

}
