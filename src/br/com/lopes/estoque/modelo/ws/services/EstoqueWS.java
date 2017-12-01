package br.com.lopes.estoque.modelo.ws.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.lopes.estoque.modelo.item.Item;
import br.com.lopes.estoque.modelo.item.ItemDao;
import br.com.lopes.estoque.modelo.item.ListaItens;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "allItens")
	@WebResult(name = "itens")
	public ListaItens getItens() {
		System.out.println("Calling getItens...");

		List<Item> lista = dao.todosItens();
		return new ListaItens(lista);
	}

}
