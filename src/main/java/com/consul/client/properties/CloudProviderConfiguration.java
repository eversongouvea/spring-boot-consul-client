package com.consul.client.properties;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;
import com.netflix.loadbalancer.RoundRobinRule;

public class CloudProviderConfiguration {

	@Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RoundRobinRule();
    }
	
	
	@Bean
    public IPing ribbonPing(IClientConfig config) {
        return new NoOpPing();
    }
}
