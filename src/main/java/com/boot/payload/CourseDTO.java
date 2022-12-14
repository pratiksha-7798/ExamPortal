package com.boot.payload;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.boot.entity.CourseEntity;
import com.boot.entity.EnrolledCoursesEntity;
import com.boot.entity.StudentEntity;
import com.boot.entity.SubjectEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class CourseDTO {
	
	  private int courseId;
      
      private String courseName;
  
      private int courseFee;
       
      @JsonIgnore
      private List<EnrolledCoursesEntity> enrolledcourseList=new ArrayList<>();
      
      @JsonIgnore 
      private List<SubjectDTO> subjectList=new ArrayList<>();
   
      
}
