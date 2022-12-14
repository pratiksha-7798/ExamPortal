package com.boot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.ExamResultReportEntity;
import com.boot.entity.ExaminationEntity;



public interface Examinationrepository  extends JpaRepository<ExaminationEntity,Integer>{

	/*List<ExaminationEntity> findByExamResultId(ExamResultReportEntity examResultId);
	 
	
	 @Query(value="select * from exam_result_report_entity er where er.examination_report_list_exam_result_id=:examResultId",nativeQuery =true)
     List<ExaminationEntity> getAllExaminationByExamResultId(@Param("examResultId") int examResultId);
	*/
}
