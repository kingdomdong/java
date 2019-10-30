package com.king.bean.grouped;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.king.bean.pojo.Address;

public class GroupTest {

	@Test
	void groupedAssersions() {
		Address address = new Address("John", "User");
		// In a grouped assertion all assertions are executed, even after a failure.
		// The error messages get grouped together.
		assertAll("address name", () -> assertEquals("John", address.getFirstName()),
				() -> assertEquals("User", address.getLastName()));
	}

}
