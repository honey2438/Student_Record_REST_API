package com.magic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic.models.Student;

public interface StudentRepo extends JpaRepository<Student, String> {
   
}
