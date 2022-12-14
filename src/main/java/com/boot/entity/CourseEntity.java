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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseEntity {
	

            @Id
            @GeneratedValue(strategy=GenerationType.AUTO)
            private int courseId;
            
            @NotEmpty( message="Course name can not be empty")
   	        @Column(nullable=false)
   	        @Size(min=2,max=20,message="course name must be minimum 2 characters and maximum 15")
   	     
            private String courseName;
 
            @NotNull(message="Course name can not be empty")
            @Min(message="Minimum Fee of student should be 500",value=500)
   	        @Max(message="Maximum Fee of student should be 2000",value=2000)
   	        private int courseFee;
            
            @JsonIgnore 
  	        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)  
  	        private List<SubjectEntity> subjectList=new ArrayList<>();

            @JsonIgnore 
  	        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)  
  	        private List<EnrolledCoursesEntity> enrolledcourseList=new ArrayList<>();
 

}
