package com.boot.service;

import java.util.List;

import com.boot.payload.ExaminationDTO;


public interface ExaminationService 
{
	 public ExaminationDTO addExamination(ExaminationDTO examination);
		
		public List<ExaminationDTO> getAllExaminationList();
		
		public ExaminationDTO getExaminationById(int examinationId);
		
		public void deleteExaminationById(int examinationId);
		
		public ExaminationDTO updateexaminationById(ExaminationDTO examination,int examinationId);

	//	public  List<ExaminationDTO> getAllExaminationByexamReportId(int examReportId);
		
}
