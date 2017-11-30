package br.com.caelum.estoque.modelo.ws.services;

import java.util.List;

import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	public List<Item> getItens() {
		System.out.println("Calling getItens...");
		return dao.todosItens();
	}

}
