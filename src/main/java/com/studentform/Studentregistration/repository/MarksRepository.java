package com.studentform.Studentregistration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentform.Studentregistration.model.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
	

}
