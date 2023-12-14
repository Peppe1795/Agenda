package com.Petrucci.Agenda.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(UUID id) {
		super(id + " non trovato!");
	}

	public NotFoundException(int id) {
		super(id + " non trovato!");
	}
}
