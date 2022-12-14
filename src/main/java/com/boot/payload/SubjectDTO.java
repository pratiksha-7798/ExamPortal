package com.boot.payload;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.boot.entity.CourseEntity;
import com.boot.entity.ExaminationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubjectDTO {
	
    private int subjectId;
	
	private String subjectName;
     
	private String subjectDiscription;
   
	private CourseDTO course;
    
	@JsonIgnore
	 private List<ExaminationDTO> examList=new ArrayList<>();

}
