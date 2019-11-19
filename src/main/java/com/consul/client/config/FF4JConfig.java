package com.consul.client.config;

import javax.sql.DataSource;

import org.ff4j.consul.ConsulConnection;
import org.ff4j.consul.store.FeatureStoreConsul;
import org.ff4j.consul.store.PropertyStoreConsul;
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.orbitz.consul.Consul;

@Configuration
public class FF4JConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	Consul consul;

	@Bean
	public org.ff4j.FF4j getFF4j() {

		ConsulConnection connection = new ConsulConnection(consul);
		FeatureStoreConsul featureStoreConsul = new FeatureStoreConsul(connection);
		PropertyStoreConsul propertyStoreConsul = new org.ff4j.consul.store.PropertyStoreConsul(connection);

		org.ff4j.FF4j ff4j = new org.ff4j.FF4j();
		ff4j.setFeatureStore(featureStoreConsul);
		ff4j.setPropertiesStore(propertyStoreConsul);
		ff4j.setEventRepository(new EventRepositorySpringJdbc(dataSource));
		ff4j.audit(true);

		return ff4j;
	}

}
