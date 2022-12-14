package com.boot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ExaminationEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int examinationId;
	
	@Column(nullable=false) 
    private String date;
	
	        @NotEmpty( message="subject name can not be empty")
	        @Column(nullable=false)
	        @Size(min=2,max=20,message="subject name must be minimum 2 characters and maximum 20")
	private String subjectName;
    
	        @NotEmpty( message="Status name can not be empty")
   	        @Column(nullable=false)
   	        @Size(min=3,max=20,message="Status name must be minimum 3 characters and maximum 20")
   	private String status;  
    
	        
	@ManyToOne
    @JoinColumn(name="SubId")
	private SubjectEntity subject;      

	@JsonIgnore
	@ManyToMany( cascade = CascadeType.ALL)
	@JoinColumn(name="ExamReportId")
	private List<ExamResultReportEntity> examinationReportList= new ArrayList<>();

	
	@JsonIgnore
	@OneToMany(mappedBy ="examination", cascade = CascadeType.ALL)
	private List<QuestionsEntity> questionList1= new ArrayList<>();

    	
}
