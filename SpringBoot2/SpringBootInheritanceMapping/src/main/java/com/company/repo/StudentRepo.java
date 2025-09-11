package com.company.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student , Long>{
	
	@EntityGraph(attributePaths = {"emails"})
	List<Student> findAll();

}
