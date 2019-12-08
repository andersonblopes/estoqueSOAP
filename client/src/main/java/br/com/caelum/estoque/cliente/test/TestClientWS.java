package br.com.caelum.estoque.cliente.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.caelum.estoque.cliente.EstoqueWS;
import br.com.caelum.estoque.cliente.EstoqueWSService;
import br.com.caelum.estoque.cliente.Filtro;
import br.com.caelum.estoque.cliente.Filtros;
import br.com.caelum.estoque.cliente.Item;
import br.com.caelum.estoque.cliente.ListaItens;
import br.com.caelum.estoque.cliente.TipoItem;

public class TestClientWS {

	public static void main(String[] args) throws MalformedURLException {

		ConsumerServiceFormOne();
		ConsumerServiceFormTwo();

	}

	public static void ConsumerServiceFormOne() {
		System.out.println("Form of  consumer service 1");
		EstoqueWS cliente = new EstoqueWSService().getEstoqueWSPort();
		System.out.println(cliente);

		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);

		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);

		ListaItens lista = cliente.todosOsItens(filtros);

		System.out.println("Resposta do serviço: " + lista.getItem().get(0).getTipo());
	}

	private static void ConsumerServiceFormTwo() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/EstoqueWS-web/EstoqueWS?wsdl");
		QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");

		Service service = Service.create(url, qname);

		EstoqueWS cliente = service.getPort(EstoqueWS.class);

		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);

		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);

		ListaItens lista = cliente.todosOsItens(filtros);

		for (Item item : lista.getItem()) {
			System.out.println(item.getNome());
		}
	}

}
