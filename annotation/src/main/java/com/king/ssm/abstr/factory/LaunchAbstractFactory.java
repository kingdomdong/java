package com.king.ssm.abstr.factory;

import com.king.ssm.factory.IProduct;

public class LaunchAbstractFactory {
	
	public static void main(String[] args) {
		IProduct product = AbstractFactory.generateIProduct("Food-004");
		System.out.println(product.getProductDesc());
	}

}
