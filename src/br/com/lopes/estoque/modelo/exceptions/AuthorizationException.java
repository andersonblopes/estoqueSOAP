package br.com.lopes.estoque.modelo.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "AuthorizationFault")
public class AuthorizationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuthorizationException(String msg) {
		super(msg);
	}

	public String getFaultInfo() {
		return "Sorry, Token i'snt valid.";
	}

}
