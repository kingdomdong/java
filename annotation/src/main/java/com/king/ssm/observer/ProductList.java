package com.king.ssm.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable{
	
	private List<String> productList = null;
	
	// single instance
	private static ProductList instance;
	
	// private constructor
	private ProductList() {} 
	
	public static ProductList getInstance() {
		if (instance == null) {
			instance = new ProductList();
			instance.productList = new ArrayList<>();
		}
		
		return instance;
	}
	
	public void addProductListObserver(Observer observer) {
		this.addObserver(observer);
	}
	
	public void addProduct(String newProduct) {
		productList.add(newProduct);
		System.out.println("product list add new item");
		this.setChanged();
		this.notifyObservers(newProduct);
	}
	
}
