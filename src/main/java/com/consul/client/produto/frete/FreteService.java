package com.consul.client.produto.frete;

import org.ff4j.aop.Flip;

public interface FreteService {

	@Flip(name="frete", alterBean="frete.promocao")
	 Double valorFrete(int quantidade, Double valorCompra);
	
}
