package com.king.ssm.observer;

public class LauncherObserver {
	
	private static void testObserver(String product) {
		ProductList productObserver = ProductList.getInstance();
		productObserver.addProductListObserver(new JingDongObserver());
		productObserver.addProductListObserver(new TaoBaoObserver());
		productObserver.addProduct(product);
	}
	
	public static void main(String[] args) {
		testObserver("Fancy Cookie");
	}

}
