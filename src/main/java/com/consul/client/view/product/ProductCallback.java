package com.consul.client.view.product;

import org.springframework.stereotype.Component;

@Component
public class ProductCallback implements JSONProduct {

	@Override
	public String getStores() {
		
		return "Mock descrição da instancia";
		
	}

	
	
}
