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
import com.boot.payload.ExamResultReportDTO;
import com.boot.payload.ExaminationDTO;
import com.boot.payload.StudentDTO;
import com.boot.service.ExamResultReportService;
import com.boot.service.ExaminationService;


@RestController
@RequestMapping("/examResultReport")
@CrossOrigin("*")
public class ExamResultReportController {

	
	@Autowired
	private ExamResultReportService examResultReportService;
	
	@PostMapping
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<ExamResultReportDTO> addExamResultReport(@Valid @RequestBody ExamResultReportDTO examResultReport)
	{	
		ExamResultReportDTO addExamResultReport = this.examResultReportService.addExamReport(examResultReport);
	
		return new ResponseEntity<ExamResultReportDTO>(addExamResultReport,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<ExamResultReportDTO>> getAllexamResultReport()
	{
		List<ExamResultReportDTO> examResultReportList = this.examResultReportService.getAllExamReportList();
		return new ResponseEntity<List<ExamResultReportDTO>>(examResultReportList,HttpStatus.OK);
		
   }
	@GetMapping("/{examResultId}")
	public ResponseEntity<ExamResultReportDTO> getExamResultReportById(@PathVariable("examResultId") int examResultId)
	{
		ExamResultReportDTO examResultReportObj = this.examResultReportService.getExamReportById(examResultId);
		return new ResponseEntity<ExamResultReportDTO>(examResultReportObj,HttpStatus.OK);
	}
	
	@PutMapping("/examResultId")
	
	public ResponseEntity<ExamResultReportDTO> updateExamResultReportById(@Valid @RequestBody ExamResultReportDTO examResultReport,@PathVariable("examResultId") int examResultId)
	{
		ExamResultReportDTO updatedExamResultReport = this.examResultReportService.updateExamReportById(examResultReport, examResultId);
		return new ResponseEntity<ExamResultReportDTO>(updatedExamResultReport,HttpStatus.OK);
	}
	
	@DeleteMapping("/examResultId")
	public ResponseEntity<ApiResponse> deleteExamResultReport(@PathVariable("examResultId")int examResultId)
	{
		this.examResultReportService.deleteExamReportById(examResultId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("record is deleted with examResultReport Id: "+examResultId);
		
		response.setStatus(true);
		//return null;
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}
	
	
	
}
