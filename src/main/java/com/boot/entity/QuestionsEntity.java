package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
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
public class QuestionsEntity {

	   @Id
	   @GeneratedValue(strategy =GenerationType.AUTO)
	   private int questionId;
	    
	   @NotEmpty(message="questions can not be empty")
	   @Column(nullable = false)
	   private String question;
	   
	   @NotNull(message="option1 can not be empty")
	   @Column(nullable = false)
	   private String option1;
	   
	   @NotNull(message="option2 can not be empty")
	   @Column(nullable = false)
	   private String option2;
	   
	   @NotNull(message="option3 can not be empty")
	   @Column(nullable = false)
	   private String option3;
	   
	   @NotNull(message="option4 can not be empty")
	   @Column(nullable = false)
	   private String option4;
	   
	   @NotNull(message="answer can not be empty")
	   @Column(nullable = false)
	   private String answer;
	   
	   @ManyToOne
	   @JoinColumn(name="ExamId")
	   private ExaminationEntity examination;     
           	   
	   
}
