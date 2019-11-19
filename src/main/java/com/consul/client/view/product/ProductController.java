package com.consul.client.view.product;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.property.Property;
import org.ff4j.property.store.PropertyStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consul.client.produto.frete.FreteService;
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

	@Autowired
	private FreteService freteService;

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

	@GetMapping("/propriedade")
	public String getProperties() {

		PropertyStore propertiesStore = ff4j.getPropertiesStore();

		String valor = "não existe";
		if (propertiesStore.existProperty("propriedade")) {
			Property<?> readProperty = propertiesStore.readProperty("propriedade");
			valor = (String) readProperty.getValue();
		}

		return String.format("Valor da properties: %s", valor);
	}
	
	@GetMapping("/mensagem")
	public String getMessage() {

		Feature feature = ff4j.getFeature("mensagem");

		if (feature.isEnable()) {
			Property<Object> property = feature.getProperty("dia");
			return (String) property.getValue();
		} else {
			Property<Object> property = feature.getProperty("noite");
			return (String) property.getValue();
		}
	}

	@GetMapping("/ponderado")
	public String ponderado() {
		
		String recurso = "Aguardando recurso";
		
		if (ff4j.check("ponderado")) {
			recurso = "Recurso ativado";
	    } 
		
		return recurso;
	}
	
	@GetMapping("/frete")
	public String frete() {

		String tarifa = ff4j.getFeature("frete").isEnable() ? "Promoção": "Normal";
		
		Double valorFrete = freteService.valorFrete(5, 25.2);
		
		return String.format("O valor cobrado para o frete da tarifa %1s : %2$,.2f",tarifa, valorFrete);
	}

}
