package com.king.bean.ssm.observer;

public class LauncherObserver {
	
	private static void testObserver(String product) {
		ProductList productObserver = ProductList.getInstance();
		
		// config observer
		productObserver.addProductListObserver(new JingDongObserver());
		productObserver.addProductListObserver(new TaoBaoObserver());
		
		// send notification
		productObserver.addProduct(product);
	}
	
	public static void main(String[] args) {
		testObserver("Fancy Cookie");
	}

}
