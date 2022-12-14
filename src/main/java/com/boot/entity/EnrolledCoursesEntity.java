package com.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnrolledCoursesEntity {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
        private int enrolledId;
       
        @ManyToOne
        @JoinColumn(name="Sid")
	      private StudentEntity student;
	
	      @ManyToOne
	      @JoinColumn(name="Cid")
	      private CourseEntity course;


}
