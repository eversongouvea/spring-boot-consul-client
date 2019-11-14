package com.consul.client.config;

import org.ff4j.consul.ConsulConnection;
import org.ff4j.consul.store.FeatureStoreConsul;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;

@Configuration
public class FF4j {

	@Value("${spring.cloud.consul.host:localhost}")
    private String consulHost;
	
    @Value("${spring.cloud.consul.port:8500}")
    private int consulPort;
	
    
    @Bean
    public org.ff4j.FF4j ff4j() {
    	
        org.ff4j.FF4j ff4jObject = new org.ff4j.FF4j().audit(true).autoCreate(true);
        
        Consul c = Consul.builder()
        		         .withHostAndPort(HostAndPort.fromParts(consulHost, consulPort))
        		         .build();
        
        ConsulConnection connection = new ConsulConnection(c);
        FeatureStoreConsul featureStoreConsul = new FeatureStoreConsul(connection);
        
        ff4jObject.setFeatureStore(featureStoreConsul);
        ff4jObject.setPropertiesStore(new org.ff4j.consul.store.PropertyStoreConsul(connection));
        
        return ff4jObject;
    }
    
}
