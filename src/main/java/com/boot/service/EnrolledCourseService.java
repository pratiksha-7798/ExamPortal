package com.boot.service;

import java.util.List;

import com.boot.payload.EnrolledCoursesDTO;

public interface EnrolledCourseService {

	
	 public EnrolledCoursesDTO addenrolledCourse(EnrolledCoursesDTO enrolledcourse);
		
		public List<EnrolledCoursesDTO> getAllEnrolledCourse();
		
		public  EnrolledCoursesDTO getEnrolledCourseById(int enrolledId);
	
		public  List<EnrolledCoursesDTO> getEnrolledCourseByStudentId(int studentId);
		
		public List<EnrolledCoursesDTO> getEnrolledCourseByCoursetId(int courseId);
		
	
}
