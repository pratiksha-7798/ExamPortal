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
import com.boot.payload.QuestionsDTO;
import com.boot.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<QuestionsDTO> addQuestion(@Valid @RequestBody QuestionsDTO question)
	{	
		QuestionsDTO addQuestions = this.questionService.addQuestion(question);
	
		return new ResponseEntity<QuestionsDTO>(addQuestions,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<QuestionsDTO>> getAllQuestions()
	{
		List<QuestionsDTO> questionsList = this.questionService.getAllQuestionList();
		return new ResponseEntity<List<QuestionsDTO>>(questionsList,HttpStatus.OK);
		
   }
	@PutMapping("/{questionId}")
	public ResponseEntity<QuestionsDTO> updateQuestionById(@Valid @RequestBody QuestionsDTO question,@PathVariable("questionId") int questionId)
	{
		QuestionsDTO updatedquestion = this.questionService.updateQuestionById(question, questionId);
		return new ResponseEntity<QuestionsDTO>(updatedquestion,HttpStatus.OK);
	}
	@DeleteMapping("/{questionId}")
	public ResponseEntity<ApiResponse> deleteQuestions(@PathVariable("questionId")int questionId)
	{
		this.questionService.deleteQuestionById(questionId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage(" record is deleted with question Id: "+questionId);
		
		response.setStatus(true);
		//return null;
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}
	
	


}
