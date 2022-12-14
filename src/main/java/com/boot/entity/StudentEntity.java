package com.boot.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.boot.payload.ExamResultReportDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class StudentEntity {
	
	     @Id
    	 @GeneratedValue(strategy=GenerationType.AUTO)
	     private int studentId;
	      
	     @NotEmpty( message="Student name can not be empty")
	     @Column(nullable=false)
	     @Size(min=2,max=15,message="Student name must be minimum 2 characters and maximum 15")
	     
	     private String studentName;
	     
	     @Column(nullable=false)
		 @NotEmpty(message="Student Qualification can not be empty")
		 @Size(min=2,max=15,message="Student class must be minimum 2 characters and maximum 15")
	     
		 private String studentQualification;

	    
	     @Column(nullable=false)
	     @NotNull(message="Student age can not be empty")
	     @Min(message="Minimum age of student should be 20",value=20)
	     @Max(message="Maximum age of student should be 30",value=30)
	     
	     private int studentAge;
	     
	     @Email(message ="Email is not valid")
	     @NotEmpty(message ="Email can not be empty")
	     @Column(nullable=false)
	     
	     private String studentEmail;
	     
	     @Column(nullable=false)
	     @NotEmpty(message="Student password can not be empty")
	     @Size(min=2,max=10,message="Student Password must be minimum 2 characters and maximum 12")
	     
		 private String studentPassword;
	    
	     @Column(nullable=false)
	     @NotEmpty(message="Student number can not be empty")
	     @Size(min=10,max=10,message="Student number must be minimum 10 and maximum 10")
		 private String studentMobileNumber;
	    
	     @JsonIgnore 
	     @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)  
	     private List<EnrolledCoursesEntity> studentList=new ArrayList<>();

	    @JsonIgnore 
	     @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)  
	     private List<ExamResultReportEntity> examReportList=new ArrayList<>();
	        
           
}




