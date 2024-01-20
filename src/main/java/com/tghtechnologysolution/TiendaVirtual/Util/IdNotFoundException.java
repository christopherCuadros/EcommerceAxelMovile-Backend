package com.tghtechnologysolution.TiendaVirtual.Util;

import java.util.NoSuchElementException;

import lombok.Getter;

public class IdNotFoundException extends NoSuchElementException{

	private static final long serialVersionUID = 1L;
	
	@Getter
	private final String type;
	
	public IdNotFoundException(String type) {
		super("No se encontro la ID especificada");
		this.type = type;
	}
	
	public void printWarn() {
		System.err.printf("[%s]%s", type, getMessage());
	}

}
