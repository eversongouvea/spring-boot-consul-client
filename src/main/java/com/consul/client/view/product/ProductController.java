package com.consul.client.view.product;

import org.ff4j.FF4j;
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

	@GetMapping("/message")
	public String getMessage() {

		PropertyStore propertiesStore = ff4j.getPropertiesStore();

		String valor = "";
		if (propertiesStore.existProperty("message")) {
			Property<?> readProperty = propertiesStore.readProperty("message");
			valor = (String) readProperty.getValue();
		}

		if (ff4j.check("f1")) {
			return valor + " FF4j f1 true";
		} else {
			return "FF4j f1 false";
		}
	}

	@GetMapping("/frete")
	public String frete() {

		String tarifa = ff4j.getFeature("frete").isEnable() ? "Promoção": "Normal";
		
		Double valorFrete = freteService.valorFrete(5, 25.2);
		
		return String.format("O valor cobrado para o frete da tarifa %1s : %2$,.2f",tarifa, valorFrete);
	}

}
