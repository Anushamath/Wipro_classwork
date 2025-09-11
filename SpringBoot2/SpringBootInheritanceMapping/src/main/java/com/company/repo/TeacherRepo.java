package com.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher , Long>{

}
