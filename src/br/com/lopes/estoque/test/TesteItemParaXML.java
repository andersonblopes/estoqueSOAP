package br.com.lopes.estoque.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.lopes.estoque.item.Item;

public class TesteItemParaXML {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws JAXBException {
		Item item = new Item.Builder().comCodigo("MEA").comNome("MEAN").comQuantidade(4).comTipo("Livro").build();

		JAXBContext context = JAXBContext.newInstance(Item.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // Format output
		marshaller.marshal(item, System.out); // Show in screen
		marshaller.marshal(item, new File("item.xml")); // Write to file
	}
}
