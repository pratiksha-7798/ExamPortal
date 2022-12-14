package com.boot.service;

import java.util.List;

import com.boot.payload.QuestionsDTO;


public interface QuestionService {
	public QuestionsDTO addQuestion(QuestionsDTO question);
	
	public List<QuestionsDTO> getAllQuestionList();
	
	public QuestionsDTO getQuestionById(int questionId);
	
	public void deleteQuestionById(int questionId);
	
	public QuestionsDTO updateQuestionById(QuestionsDTO question,int questionId);


}
