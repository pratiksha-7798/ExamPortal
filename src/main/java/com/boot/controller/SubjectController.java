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
import com.boot.payload.StudentDTO;
import com.boot.payload.SubjectDTO;
import com.boot.service.SubjectService;


@RestController
@RequestMapping("/subject")
@CrossOrigin("*")
public class SubjectController {


	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<SubjectDTO> addSubject(@Valid @RequestBody SubjectDTO subject)
	{	
		SubjectDTO addSubject = this.subjectService.addSubject(subject);
	
		return new ResponseEntity<SubjectDTO>(addSubject,HttpStatus.CREATED);
		
	}
    
	@GetMapping("/")
	public ResponseEntity<List<SubjectDTO>> getAllSubject()
	{
		List<SubjectDTO> allsubjectList = this.subjectService.getAllSubjectList();
		return new ResponseEntity<List<SubjectDTO>>(allsubjectList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{subjectId}")
	public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable("subjectId") int subjectId)
	{
		SubjectDTO subjectObj = this.subjectService.getSubjectById(subjectId);
		return new ResponseEntity<SubjectDTO>(subjectObj,HttpStatus.OK);
	}
	
@PutMapping("/{subjectId}")
	
	public ResponseEntity<SubjectDTO> updateSubjectById(@Valid @RequestBody SubjectDTO subject,@PathVariable("subjectId") int subjectId)
	{
		SubjectDTO updatedSubject = this.subjectService.updateSubjectById(subject, subjectId);
		return new ResponseEntity<SubjectDTO>(updatedSubject,HttpStatus.OK);
	}
	
@DeleteMapping("/{subjectId}")
public ResponseEntity<ApiResponse> deleteSubject(@PathVariable("subjectId")int subjectId)
{
	this.subjectService.deleteSubjectById(subjectId);
	
	ApiResponse response=new ApiResponse();
	
	response.setMessage("subject record is deleted with subject Id: "+subjectId);
	
	response.setStatus(true);
	//return null;
    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
    			
}


}