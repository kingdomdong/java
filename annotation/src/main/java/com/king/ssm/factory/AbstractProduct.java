package com.king.ssm.factory;

public abstract class AbstractProduct implements IProduct {

	protected String productDesc;
	
	@Override
	public String getProductDesc() {
		return productDesc;
	}

}
