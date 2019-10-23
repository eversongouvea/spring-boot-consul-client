package com.consul.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consul.client.web.config.ConfigConsul;

@RestController
@RequestMapping(value = "my-app")
public class InitController {

	@Autowired
	private ConfigConsul config;
	
	@GetMapping
	public String init() {
		
		return config.getProp();
		
	}
	
}
