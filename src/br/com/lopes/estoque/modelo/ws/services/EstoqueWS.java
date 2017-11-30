package br.com.lopes.estoque.modelo.ws.services;

import java.util.List;

import javax.jws.WebService;

import br.com.lopes.estoque.modelo.item.Item;
import br.com.lopes.estoque.modelo.item.ItemDao;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	public List<Item> getItens() {
		System.out.println("Calling getItens...");
		return dao.todosItens();
	}

}
