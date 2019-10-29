package com.king.bean.ssm.abstr.factory;

import com.king.bean.ssm.factory.IProduct;

public interface IProductFactory {
	
	public IProduct generateProduct(String productNo);

}
