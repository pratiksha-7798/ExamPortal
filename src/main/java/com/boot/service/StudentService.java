package com.boot.service;

import java.util.List;

import com.boot.entity.StudentEntity;
import com.boot.payload.StudentDTO;

public interface StudentService {

	public StudentDTO addStudent(StudentDTO student);
	
	public List<StudentDTO> getAllStudentList();
	
	public StudentDTO getStudentById(int studentId);
	
	public void deleteStudentById(int studentId);
	
	public StudentDTO updateStudentById(StudentDTO student,int studentId);
	
	public StudentEntity checkLogin(String studentEmail,String studentPassword);
	
}
