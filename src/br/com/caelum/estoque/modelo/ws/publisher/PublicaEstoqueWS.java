package br.com.caelum.estoque.modelo.ws.publisher;

import javax.xml.ws.Endpoint;

import br.com.caelum.estoque.modelo.ws.services.EstoqueWS;

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("EstoqueWS rodando: " + URL);

		// Associate URL wich implementation
		Endpoint.publish(URL, implementacaoWS);

	}

}
