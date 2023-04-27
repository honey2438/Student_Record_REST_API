package com.magic.models;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Student {
	@Id
	@Column(unique = true)
	private String enrollmentId;
	@NotNull(message = "Address is required")

	@Embedded
	private Address address;
	@NotNull(message = "Name is required")
	private String name;
	@NotNull(message = "Dob is required")
	private String dob;
	@NotNull(message = "Branch is required")
	@Pattern(regexp = "Computer Science and Engineering|Mechanical Engineering|Electrical Engineering", message = "only Computer Science and Engineering, Machanical Engineering, Electrical Engineering are allowed ")
	private String branch;

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Student(String enrollmentId, @NotNull(message = "Address is required") Address address,
			@NotNull(message = "Name is required") String name, @NotNull(message = "Dob is required") String dob,
			@NotNull(message = "Branch is required") @Pattern(regexp = "Computer Science and Engineering|Machanical Engineering|Electrical Engineering", message = "only Computer Science and Engineering, Machanical Engineering, Electrical Engineering are allowed ") String branch) {
		super();
		this.enrollmentId = enrollmentId;
		this.address = address;
		this.name = name;
		this.dob = dob;
		this.branch = branch;
	}


}
