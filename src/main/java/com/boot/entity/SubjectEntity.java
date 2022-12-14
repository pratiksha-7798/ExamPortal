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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectId;
	
	 @NotEmpty( message="Subject name can not be empty")
     @Column(nullable=false)
     @Size(min=2,max=15,message="Subject name must be minimum 2 characters and maximum 15")
     private String subjectName;
    
	 
	 @NotEmpty( message="Discription  can not be empty")
     @Column(nullable=false)
     @Size(min=2,max=15,message="Discription must be minimum 2 characters and maximum 15")
    
	private String subjectDiscription;
  
    @ManyToOne
    @JoinColumn(name="Cid")
    private CourseEntity course; 
 

    @JsonIgnore 
    @JoinColumn(name="ExamId")
    @OneToMany(cascade = CascadeType.ALL)
    private List<ExaminationEntity> ExamList=new ArrayList<>();

    
}
