package com.consul.client.web.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "product", url = "https://jsonplaceholder.typicode.com/")
public interface JSONProduct {

	@RequestMapping(method = RequestMethod.GET, value = "/desction-product/stores")
    String getStores();
	
}
