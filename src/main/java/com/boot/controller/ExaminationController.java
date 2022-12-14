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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.StudentEntity;
import com.boot.exception.ApiResponse;
import com.boot.payload.CourseDTO;
import com.boot.payload.ExamResultReportDTO;
import com.boot.payload.ExaminationDTO;
import com.boot.payload.StudentDTO;
import com.boot.service.ExaminationService;

@RestController
@RequestMapping("/examination")
@CrossOrigin("*")

public class ExaminationController {

	@Autowired
	
	private ExaminationService examinationService;
	
	@PostMapping
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<ExaminationDTO> addExamination(@Valid @RequestBody ExaminationDTO examination)
	{	
		ExaminationDTO addExamination = this.examinationService.addExamination(examination);
	
		return new ResponseEntity<ExaminationDTO>(addExamination,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ExaminationDTO>> getAllExamination()
	{
		List<ExaminationDTO> examinationList = this.examinationService.getAllExaminationList();
		return new ResponseEntity<List<ExaminationDTO>>(examinationList,HttpStatus.OK);
	}
	
	@GetMapping("/{examinationId}")
	public ResponseEntity<ExaminationDTO> getExaminationById(@PathVariable("examinationId") int examinationId)
	{
		ExaminationDTO examinationObj = this.examinationService.getExaminationById(examinationId);
		return new ResponseEntity<ExaminationDTO>(examinationObj,HttpStatus.OK);
	}
	
	@PutMapping("/{examinationId}")
	
	public ResponseEntity<ExaminationDTO> updateExaminationById(@Valid @RequestBody ExaminationDTO examination,@PathVariable("examinationId") int examinationId)
	{
		ExaminationDTO updatedExamination = this.examinationService.updateexaminationById(examination, examinationId);
		return new ResponseEntity<ExaminationDTO>(updatedExamination,HttpStatus.OK);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteExamination(@PathVariable("examinationId")int examinationId)
	{
		this.examinationService.deleteExaminationById(examinationId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("record is deleted with student Id: "+examinationId);
		
		response.setStatus(true);
		//return null;
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}
	    
/*	@GetMapping("/examResultReport/{examResultId}")
	public ResponseEntity<List<ExaminationDTO>>getAllExamResultReportByExaminationId(@PathVariable("examResultId") int examResultId)
	{
		List<ExaminationDTO> examinationList= this.examinationService.getAllExaminationByexamReportId(examResultId);
	   return new ResponseEntity<List<ExaminationDTO>>(examinationList,HttpStatus.OK);	
	}*/

}
