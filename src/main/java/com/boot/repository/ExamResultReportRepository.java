package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.ExamResultReportEntity;
import com.boot.entity.ExaminationEntity;


public interface ExamResultReportRepository  extends JpaRepository<ExamResultReportEntity,Integer> {


	/*List<ExamResultReportEntity> findByExamResultId(ExaminationEntity examinationId);
	
	 @Query(value="select * from examination_entity ec where ec.examination_entity_examination_id=:examinationId",nativeQuery =true)
     List<ExamResultReportEntity> getAllExamResultReportByexaminationId(@Param("examinationId") int examinationId);
	*/
}
