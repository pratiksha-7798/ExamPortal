package com.boot.serviceemplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.StudentDTO;
import com.boot.repository.StudentRepository;
import com.boot.service.StudentService;

@Service
public class StudentServiceEmplementation implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
     @Autowired
     private ModelMapper modelMapper;
     
	

	@Override
	public StudentDTO addStudent(StudentDTO student) {
	

		StudentEntity studentEntity =this.modelMapper.map(student,StudentEntity.class);
		StudentEntity savedStudentEntity=this.studentRepository.save(studentEntity);
		return this.modelMapper.map(savedStudentEntity,StudentDTO.class);
		
	}

	@Override
	public List<StudentDTO> getAllStudentList() {
		List<StudentEntity> studentList =this.studentRepository.findAll();
		List<StudentDTO>  studentListDto = studentList.stream()
				                                    .map(student->this.modelMapper.map(student, StudentDTO.class)) 
				                                    .collect(Collectors.toList());

		return studentListDto;
}

	@Override
	public StudentDTO getStudentById(int studentId) {
		StudentEntity studentObj=this.studentRepository.
                findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student","studentID", studentId));	          
      
return this.modelMapper.map(studentObj,StudentDTO.class);

		}

	@Override
	public void deleteStudentById(int studentId) {
		if(this.studentRepository.existsById(studentId))
		{
			this.studentRepository.deleteById(studentId);
		}
		else
		{
			throw new ResourceNotFoundException("student","studentID", studentId);	
		}
	
	
	}

	@Override
	public StudentDTO updateStudentById(StudentDTO student, int studentId) {
		if(this.studentRepository.existsById(studentId))
	    {
	    	StudentEntity studentObj= this.modelMapper.map(student, StudentEntity.class);
	    	StudentEntity updatedStudent=this.studentRepository.save(studentObj);
	    	
	    	return this.modelMapper.map(updatedStudent, StudentDTO.class);
	    	}
	    else
	    {
	    	throw new ResourceNotFoundException("Student","StudentID",studentId);
	    }

		
}
	@Override
	public StudentEntity checkLogin(String studentEmail, String studentPassword) 
	{
       StudentEntity student=this.studentRepository.findByStudentEmailAndStudentPassword(studentEmail, studentPassword);
       return student;
		
	}

}	
