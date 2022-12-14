package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.payload.EnrolledCoursesDTO;
import com.boot.service.EnrolledCourseService;

@RestController
@RequestMapping("/enrolledCourse")
public class EnrolledCoiurseController {

	@Autowired
	 private EnrolledCourseService enrolledCourseService;
	
	@PostMapping("/addCourse")
	public ResponseEntity<EnrolledCoursesDTO> addenrolledCourse(@Valid @RequestBody EnrolledCoursesDTO enroledCoursesDTO)
	{
		EnrolledCoursesDTO enrolledCourse =this.enrolledCourseService.addenrolledCourse(enroledCoursesDTO);
	    return new ResponseEntity<EnrolledCoursesDTO>(enroledCoursesDTO,HttpStatus.CREATED);
	}
 
	
	@GetMapping("/")
	public ResponseEntity<List<EnrolledCoursesDTO>> getAllEnrolledCourses()
	{
		
		List<EnrolledCoursesDTO> enrolledcourseList = this.enrolledCourseService.getAllEnrolledCourse();
		return new ResponseEntity<List<EnrolledCoursesDTO>>(enrolledcourseList,HttpStatus.OK);
		
  }
	
	@GetMapping("/{enrolledId}")
	public ResponseEntity<EnrolledCoursesDTO> getEnrolledCourseById(@PathVariable("enrolledId") int enrolledId)
	{
		EnrolledCoursesDTO  enrolledcourse = this.enrolledCourseService.getEnrolledCourseById(enrolledId);
		return new ResponseEntity<EnrolledCoursesDTO>(enrolledcourse,HttpStatus.OK);
	}
  
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<EnrolledCoursesDTO>>getAllEnrolledCoursesByStudentId(@PathVariable("studentId") int studentId)
	{
		List<EnrolledCoursesDTO> enrolledCourseList= this.enrolledCourseService.getEnrolledCourseByStudentId(studentId);
	   return new ResponseEntity<List<EnrolledCoursesDTO>>(enrolledCourseList,HttpStatus.OK);	
	}


	@GetMapping("/course/{courseId}")
	public ResponseEntity<List<EnrolledCoursesDTO>>getAllEnrolledCoursesBycourseId(@PathVariable("courseId") int courseId)
	{
		List<EnrolledCoursesDTO> enrolledCourseList= this.enrolledCourseService.getEnrolledCourseByCoursetId(courseId);
	   return new ResponseEntity<List<EnrolledCoursesDTO>>(enrolledCourseList,HttpStatus.OK);	
	}


}
