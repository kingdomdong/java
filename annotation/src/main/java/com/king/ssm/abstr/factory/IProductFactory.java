package com.king.ssm.abstr.factory;

import com.king.ssm.factory.IProduct;

public interface IProductFactory {
	
	public IProduct generateProduct(String productNo);

}
