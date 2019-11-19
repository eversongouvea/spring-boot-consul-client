package com.consul.client.produto.frete;

import org.springframework.stereotype.Component;

@Component("frete.promocao")
public class FreteServicePromocaoImpl implements FreteService{

	@Override
	public Double valorFrete(int quantidade, Double valorCompra) {
		
		Double tarifa =  valorCompra * 0.2;
		
		return quantidade * tarifa ;
		
	}

}
