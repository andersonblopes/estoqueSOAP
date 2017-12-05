package br.com.lopes.estoque.exceptions.fault;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	private String msg;
	private Date dateFault;

	public InfoFault() {

	}

	public InfoFault(String msg, Date datefault) {
		this.msg = msg;
		this.dateFault = datefault;
	}

}
