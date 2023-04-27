package com.magic.services;

import com.magic.models.Address;
import com.magic.models.Student;

public interface StudentServices {

	Student createStudentResource(Student student);

	Student getStudentResource(String enrollmentId);

	Student updateStudentResource(String enrollmentId, Address address);

	void deleteStudentResource(String enrollmentId);

}
