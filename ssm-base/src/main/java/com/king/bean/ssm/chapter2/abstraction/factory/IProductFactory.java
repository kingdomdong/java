package com.king.bean.ssm.chapter2.abstraction.factory;

import com.king.bean.ssm.chapter2.factory.IProduct;

public interface IProductFactory {
	
	public IProduct generateProduct(String productNo);

}
