package com.boot.payload;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import com.boot.entity.ExaminationEntity;
import com.boot.entity.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamResultReportDTO {

	
	private int examResultId;
 	
	private int no_of_Questions;
	
	private int get_Marks;
	
	private int total_Marks;
	
    private int attemptedQuestions;
    
    private StudentDTO student;
    
    @JsonIgnore
    private List<ExaminationDTO> examReportList= new ArrayList<>(); 
	
}
