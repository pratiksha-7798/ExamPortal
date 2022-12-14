package com.boot.serviceemplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.EnrolledCoursesEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.EnrolledCoursesDTO;
import com.boot.repository.CourseRepository;
import com.boot.repository.EnrolledCourseRepository;
import com.boot.repository.StudentRepository;
import com.boot.service.EnrolledCourseService;

@Service
public class EnrolledCourseImplementation  implements EnrolledCourseService
{
	@Autowired
	private EnrolledCourseRepository enrolledCourseRepository;  
	
	@Autowired	
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EnrolledCoursesDTO addenrolledCourse(EnrolledCoursesDTO enrolledcourse)
	{
		EnrolledCoursesEntity enrolledCourseEntity= this.modelMapper.map(enrolledcourse, EnrolledCoursesEntity.class);
		EnrolledCoursesEntity savedEnrolledCourse =this.enrolledCourseRepository.save(enrolledCourseEntity);
	 	
		return this.modelMapper.map(savedEnrolledCourse, EnrolledCoursesDTO.class);
		}

	@Override
	public List<EnrolledCoursesDTO> getAllEnrolledCourse() {

		List<EnrolledCoursesEntity> enrolledCoursesList = this.enrolledCourseRepository.findAll();
		List<EnrolledCoursesDTO>  enrolledCoursesDTOList = enrolledCoursesList.stream().map(enrolledCourses->this.
				modelMapper.map(enrolledCourses, EnrolledCoursesDTO.class))
				.collect(Collectors.toList());
		return enrolledCoursesDTOList;
	
	}

	@Override
	public EnrolledCoursesDTO getEnrolledCourseById(int enrolledId) {
		if(this.enrolledCourseRepository.existsById(enrolledId)) 
		{
			EnrolledCoursesEntity enrolledCourseEntity = this.enrolledCourseRepository.findById(enrolledId).get();
			
			return this.modelMapper.map(enrolledCourseEntity, EnrolledCoursesDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("enrolledCourses","EnrolledCourseId", enrolledId);
		}

	}

	

	@Override
	public List<EnrolledCoursesDTO> getEnrolledCourseByStudentId(int studentId)
	{
		 if(this.studentRepository.existsById(studentId))
		    {
		 
		List<EnrolledCoursesEntity> enrolledCoursesList =this.enrolledCourseRepository.getAllEnrolledCourseByStudentId(studentId);
   	 
    	List<EnrolledCoursesDTO> enrolledCourseDTOList =enrolledCoursesList.stream()
    	   .map(enrolledCourse ->this.modelMapper.map(enrolledCourse, EnrolledCoursesDTO.class))
    	   .collect(Collectors.toList());
    	
    	
    	return enrolledCourseDTOList;
    	
    	
    	}
    else
    {
    	throw new ResourceNotFoundException("Student","StudentID",studentId);
    }

	}

	@Override
	public List<EnrolledCoursesDTO> getEnrolledCourseByCoursetId(int courseId) {
		if(this.courseRepository.existsById(courseId))
		{
		// TODO Auto-generated method stub
		List<EnrolledCoursesEntity> enrolledCoursesList =this.enrolledCourseRepository.getAllEnrolledCourseByCourseId(courseId);   	 
    	List<EnrolledCoursesDTO> enrolledCourseDTOList =enrolledCoursesList.stream()
    	   .map(enrolledCourse ->this.modelMapper.map(enrolledCourse, EnrolledCoursesDTO.class))
    	   .collect(Collectors.toList());
    	
    	
    	return enrolledCourseDTOList;
    	
    	
    	}
    else
    {
    	throw new ResourceNotFoundException("Course","CourseID",courseId);
    }
	
	
	}
}
