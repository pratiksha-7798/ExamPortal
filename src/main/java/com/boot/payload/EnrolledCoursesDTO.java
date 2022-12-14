package com.boot.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnrolledCoursesDTO {

        private int enrolledId;
    
	
	   private StudentDTO student;
	
	
     private CourseDTO course;
}
