package com.king.bean.ssm.chapter2.abstraction.factory;

import com.king.bean.ssm.chapter2.factory.IProduct;

public interface IProductFactory {
	
	IProduct generateProduct(String productNo);

}
