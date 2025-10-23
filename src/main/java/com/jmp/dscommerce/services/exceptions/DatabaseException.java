package com.jmp.dscommerce.services.exceptions;

@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException{

	public DatabaseException(String msg) {
		super(msg);
	}
}
