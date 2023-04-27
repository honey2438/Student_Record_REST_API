package com.magic.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressTest {
	Address address = new Address("st paul", "Amravati", "1234");

	@Test
	void testGetCity() {
		address.setCity("Kerela");
		assertEquals("Kerela", address.getCity());
	}

	@Test
	void testGetState() {
		address.setState("MP");
		assertEquals("MP", address.getState());
	}

	@Test
	void testGetPincode() {
		address.setPincode("12345");
		assertEquals("12345", address.getPincode());
	}
}
