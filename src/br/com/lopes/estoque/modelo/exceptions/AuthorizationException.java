package br.com.lopes.estoque.modelo.exceptions;

import java.util.Date;

import javax.xml.ws.WebFault;

import br.com.lopes.estoque.modelo.exceptions.fault.InfoFault;

@WebFault(name = "AuthorizationFault")
public class AuthorizationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuthorizationException(String msg) {
		super(msg);
	}

	public InfoFault getFaultInfo() {
		return new InfoFault("Sorry, Token i'snt valid. ", new Date());
	}

}
