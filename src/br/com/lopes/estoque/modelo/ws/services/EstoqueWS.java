package br.com.lopes.estoque.modelo.ws.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.lopes.estoque.modelo.item.Filtro;
import br.com.lopes.estoque.modelo.item.Filtros;
import br.com.lopes.estoque.modelo.item.Item;
import br.com.lopes.estoque.modelo.item.ItemDao;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "AllItens")
	@RequestWrapper(localName = "listItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {

		System.out.println("Calling getItens...");

		List<Filtro> lista = filtros.getLista();

		List<Item> itensResultado = dao.todosItens(lista);
		return itensResultado;
	}

	@WebMethod(operationName = "AddItem")
	@WebResult(name = "item")
	public Item addItem(@WebParam(name = "Item") Item item) {
		System.out.println("cadastrando um ítem: " + item);
		this.dao.cadastrar(item);
		return item;
	}

}
