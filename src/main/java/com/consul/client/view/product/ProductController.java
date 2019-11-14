package com.consul.client.view.product;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consul.client.properties.ConfigConsul;

@RestController
@RequestMapping(value = "product")
public class ProductController {

	
	@Autowired
    private FF4j ff4j;
	
	@Autowired
	private ConfigConsul config;
	
	@Autowired
	private JSONProduct jSONProduct;
	
	@GetMapping
	public String init() {
		
		return config.getProp();
		
	}
	
	@GetMapping(path = "/prop")
	public String prop() {
		
		return config.getProp();
		
	}
	
	@GetMapping(path = "/desction")
	public String product() {
		
		return jSONProduct.getStores();

	}
	
	@GetMapping("/message")
    public String getMessage() {

        if (ff4j.check("f1")) {
            return "FF4j f1 true";
        } else {
        	return "FF4j f1 false";
        }
   }
	
}
