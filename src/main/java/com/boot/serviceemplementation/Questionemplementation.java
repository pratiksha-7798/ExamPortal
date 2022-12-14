package com.boot.serviceemplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CourseEntity;
import com.boot.entity.QuestionsEntity;
import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.CourseDTO;
import com.boot.payload.QuestionsDTO;
import com.boot.payload.StudentDTO;
import com.boot.repository.QuestionRepository;
import com.boot.service.QuestionService;

@Service
public class Questionemplementation implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public QuestionsDTO addQuestion(QuestionsDTO question) {

		QuestionsEntity questionEntity =this.modelMapper.map(question,QuestionsEntity.class);
		QuestionsEntity savedquestionEntity=this.questionRepository.save(questionEntity);
		return this.modelMapper.map(savedquestionEntity,QuestionsDTO.class);
}

	@Override
	public List<QuestionsDTO> getAllQuestionList() {
		List<QuestionsEntity> questionsList =this.questionRepository.findAll();
		List<QuestionsDTO>  questionsListDto =questionsList.stream()
				                                    .map(questions->this.modelMapper.map(questions,QuestionsDTO.class)) 
				                                    .collect(Collectors.toList());

		return questionsListDto;
}

	@Override
	public QuestionsDTO getQuestionById(int questionId) {
           QuestionsEntity questionObj=this.questionRepository.
                findById(questionId).orElseThrow(()-> new ResourceNotFoundException("question","questionID", questionId));	          
      
return this.modelMapper.map(questionObj,QuestionsDTO.class);

	}

	@Override
	public void deleteQuestionById(int questionId) {
		if(this.questionRepository.existsById(questionId))
		{
			this.questionRepository.deleteById(questionId);
		}
		else
		{
			throw new ResourceNotFoundException("question","questionID", questionId);	
		}
	
	}

	@Override
	public QuestionsDTO updateQuestionById(QuestionsDTO question, int questionId) {
		if(this.questionRepository.existsById(questionId))
	    {
	    	QuestionsEntity questionObj= this.modelMapper.map(question, QuestionsEntity.class);
	    	QuestionsEntity updatedquestion=this.questionRepository.save(questionObj);
	    	
	    	return this.modelMapper.map(updatedquestion, QuestionsDTO.class);
	    	}
	    else
	    {
	    	throw new ResourceNotFoundException("question","questionID",questionId);
	    }
		}
	}


