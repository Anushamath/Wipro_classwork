package com.example.springhibernate_onetomany.dao;

import com.example.springhibernate_onetomany.entity.Student;

public interface IStudentDao
{
	public void saveStudent(Student student);
	public Student getStudent(Long id) ;
}