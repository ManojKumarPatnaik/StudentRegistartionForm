package com.studentform.Studentregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.studentform.Studentregistration.dto.StudentRequestInput;
import com.studentform.Studentregistration.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	

	

	
	
	


}
