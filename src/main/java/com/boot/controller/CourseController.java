package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exception.ApiResponse;
import com.boot.payload.CourseDTO;
import com.boot.payload.StudentDTO;
import com.boot.service.CourseService;


@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<CourseDTO> addCourse(@Valid @RequestBody CourseDTO course)
	{	
		CourseDTO addCourse = this.courseService.addCourse(course);
	
		return new ResponseEntity<CourseDTO>(addCourse,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<CourseDTO>> getAllCourses()
	{
		List<CourseDTO> courseList = this.courseService.getAllCourseList();
		return new ResponseEntity<List<CourseDTO>>(courseList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDTO> getCourseById(@PathVariable("courseId") int courseId)
	{
		CourseDTO  course = this.courseService.getCourseById(courseId);
		return new ResponseEntity<CourseDTO>(course,HttpStatus.OK);
	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<CourseDTO> updatecourseById(@Valid @RequestBody CourseDTO course,@PathVariable("courseId") int courseId)
	{
		CourseDTO updatedCourse = this.courseService.updateCourseById(course, courseId);
		return new ResponseEntity<CourseDTO>(updatedCourse,HttpStatus.OK);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<ApiResponse> deleteCourse(@PathVariable("courseId")int courseId)
	{
		this.courseService.deleteCourseById(courseId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("course record is deleted with student Id: "+courseId);
		
		response.setStatus(true);
		//return null;
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}


}
