package com.consul.client.view.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consul.client.properties.ConfigConsul;

@RestController
@RequestMapping(value = "product")
public class ProductController {

	@Autowired
	private ConfigConsul config;
	
	@Autowired
	private JSONProduct jSONProduct;
	
	@GetMapping
	public String init() {
		
		return config.getProp();
		
	}
	
	@GetMapping(path = "/desction")
	public String product() {
		
		return jSONProduct.getStores();
		
	}
	
}
