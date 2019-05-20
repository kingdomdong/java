package com.king.ssm.observer;

import java.util.Observable;
import java.util.Observer;

public class JingDongObserver implements Observer {

	@Override
	public void update(Observable o, Object product) {
		String newProduct = product.toString();
		System.out.println("send new product informatioin to JingDong platform: " + newProduct);
	}

}
