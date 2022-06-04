package org.serratec.backend.projetofinalecommerce.exceptions;

public class UsuarioException extends Exception {
	private static final long serialVersionUID = 1L;

	public UsuarioException() {
		super();
	}

	public UsuarioException(String message) {
		super(message);
	}

	public UsuarioException(String message, Exception cause) {
		super(message, cause);
	}

	public UsuarioException(Exception e) {
		super(e);
	}
}
