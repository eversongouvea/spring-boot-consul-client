package com.consul.client.view.product;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consul.client.properties.CloudProviderConfiguration;

@RibbonClient(name= "product",configuration = CloudProviderConfiguration.class)
@FeignClient(name= "product",fallback = ProductCallback.class)
public interface JSONProduct {

	
	@RequestMapping(method = RequestMethod.GET, value = "/product/desction")
    String getStores();
	
}
