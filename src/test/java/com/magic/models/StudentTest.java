package com.magic.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
	private Student student;

	@BeforeEach
	public void setUp() {
		student = new Student("1234", new Address("123 Main St", "Los Angeles", "1001"), "John Doe", "1995-01-01",
				"Computer Science and Engg");

	}

	@Test
	public void testGetEnrollmentId() {
		String enrollmentId = student.getEnrollmentId();
		assertEquals("1234", enrollmentId);
	}

	@Test
	public void testSetEnrollmentId() {
		student.setEnrollmentId("5678");
		String enrollmentId = student.getEnrollmentId();
		assertEquals("5678", enrollmentId);
	}

	@Test
	public void testGetName() {
		String name = student.getName();
		assertEquals("John Doe", name);
	}

	@Test
	public void testSetName() {
		student.setName("Jane Smith");
		String name = student.getName();
		assertEquals("Jane Smith", name);
	}

	@Test
	public void testGetDob() {
		String dob = student.getDob();
		assertEquals("1995-01-01", dob);
	}

	@Test
	public void testSetDob() {
		student.setDob("1994-12-31");
		String dob = student.getDob();
		assertEquals("1994-12-31", dob);
	}

	@Test
	public void testGetBranch() {
		String branch = student.getBranch();
		assertEquals("Computer Science and Engg", branch);
	}

	@Test
	public void testSetBranch() {
		student.setBranch("Electrical Engineering");
		String branch = student.getBranch();
		assertEquals("Electrical Engineering", branch);
	}

	@Test
	public void testGetAddress() {
		Address address = student.getAddress();
		assertEquals(new Address("123 Main St", "Los Angeles", "1001").getCity(), address.getCity());
	}

	@Test
	public void testSetAddress() {
		student.setAddress(new Address("456 Main St", "Los Angeles", "1001"));
		Address address = student.getAddress();
		assertEquals(new Address("456 Main St", "Los Angeles", "1001").getCity(), address.getCity());
	}
}
