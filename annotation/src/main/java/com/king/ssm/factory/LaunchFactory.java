package com.king.ssm.factory;

public class LaunchFactory {

	private static void testFactory(Integer productNo) {
		FoodFactory foodFactory = new FoodFactory();
		IProduct product = foodFactory.generateProduct("005");
		System.out.println(product.getProductDesc());
	}

	public static void main(String[] args) {
		testFactory(1);
	}

}
