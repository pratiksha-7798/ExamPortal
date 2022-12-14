package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class ExamResultReportEntity {
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examResultId;
    
	@NotNull(message="no_of_Questions can not be empty")
	@Column(nullable = false)
	private int no_of_Questions;
	
	
	@NotNull(message="get_marks can not be empty")	
	@Column(nullable = false) 
	private int get_Marks;
	
	@NotNull(message="total_marks can not be empty")	
	@Column(nullable = false)
	private int total_Marks;
	
	@NotNull(message="no_of_AttemptQuestions can not be empty")	
	@Column(nullable = false)
	private int attemptedQuestions;
	

	@JsonIgnore
	@JoinColumn(name="ExamId")
	@ManyToMany(cascade = CascadeType.ALL)
    private List<ExaminationEntity> examReportList= new ArrayList<>(); 
	
	@ManyToOne
    @JoinColumn(name="Sid")
    private StudentEntity student;

}
