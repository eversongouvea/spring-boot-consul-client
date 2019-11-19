package com.consul.client.produto.frete;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("frete.nomal")
@Primary
public class FreteServiceNomalImpl implements FreteService{

	@Override
	public Double valorFrete(int quantidade, Double valorCompra) {
		
		Double tarifa =  valorCompra * 0.5;
		
		return quantidade * tarifa ;
	}

}
