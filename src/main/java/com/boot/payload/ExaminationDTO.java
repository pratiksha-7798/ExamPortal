package com.boot.payload;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.boot.entity.ExamResultReportEntity;
import com.boot.entity.QuestionsEntity;
import com.boot.entity.SubjectEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationDTO {

	
private int examinationId;
	
    private String date;
	
    private String subjectName;
    
	private String status;  
    
	private SubjectDTO subject; 
	
	@JsonIgnore
	private List<ExamResultReportDTO> examinationReportList= new ArrayList<>();
	
	@JsonIgnore
	private List<QuestionsDTO> questionList1= new ArrayList<>();

}
