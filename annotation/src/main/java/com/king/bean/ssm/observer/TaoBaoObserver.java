package com.king.bean.ssm.observer;

import java.util.Observable;
import java.util.Observer;

public class TaoBaoObserver implements Observer {

	@Override
	public void update(Observable o, Object product) {
		String newProduct = product.toString();
		System.out.println("send new product information to TaoBao platform: " + newProduct);
	}
	
}
