package com.king.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.king.entity.User;

public class ExceptingException {
	
	private final User user = new User();
	
	@Test
	void expectingException() {
		// set up user
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> user.setAge("23")); // expectThrows - Deprecated
		assertEquals("Age must be an Integer.", exception.getMessage());
	}

}
