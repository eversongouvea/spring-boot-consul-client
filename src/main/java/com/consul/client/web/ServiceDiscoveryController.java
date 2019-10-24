package com.consul.client.web;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "services")
public class ServiceDiscoveryController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping
	public Optional<URI> serviceURL(){
		return discoveryClient.getInstances("client")
				.stream()
				.map(instance -> instance.getUri())
				.findFirst();
	}
	
}
