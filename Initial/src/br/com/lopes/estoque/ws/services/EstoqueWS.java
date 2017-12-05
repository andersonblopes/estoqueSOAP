package br.com.lopes.estoque.ws.services;

import java.io.File;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.lopes.estoque.exceptions.AuthorizationException;
import br.com.lopes.estoque.item.Filtro;
import br.com.lopes.estoque.item.Filtros;
import br.com.lopes.estoque.item.Item;
import br.com.lopes.estoque.item.ItemDao;
import br.com.lopes.estoque.item.ItemValidador;
import br.com.lopes.estoque.usuario.TokenDao;
import br.com.lopes.estoque.usuario.TokenUsuario;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
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
	public Item addItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name = "Item") Item item) throws AuthorizationException {
		System.out.println("cadastrando um ítem: " + item + " Token: " + token);

		boolean valid = new TokenDao().ehValido(token);

		if (!valid) {
			throw new AuthorizationException("Access denied!");
		}

		new ItemValidador(item).validate();

		this.dao.cadastrar(item);
		return item;
	}

	@WebMethod(operationName = "GenerateItemReport")
	@Oneway // method not response
	@SuppressWarnings("static-access")
	public void generateReport() {
		Item item = new Item.Builder().comCodigo("MEA").comNome("MEAN").comQuantidade(4).comTipo("Livro").build();

		Marshaller marshaller;
		try {
			JAXBContext context = JAXBContext.newInstance(Item.class);
			marshaller = context.createMarshaller();
			marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // Format output
			marshaller.marshal(item, System.out); // Show in screen
			marshaller.marshal(item, new File("item.xml")); // Write to file
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
