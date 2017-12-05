package br.com.lopes.estoque.ws.publisher;

import javax.xml.ws.Endpoint;

import br.com.lopes.estoque.ws.services.EstoqueWS;

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("EstoqueWS done: " + URL);

		// Associate URL wich implementation
		Endpoint.publish(URL, implementacaoWS);

	}

}
