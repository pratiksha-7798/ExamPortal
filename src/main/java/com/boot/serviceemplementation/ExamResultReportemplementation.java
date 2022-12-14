package com.boot.serviceemplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CourseEntity;
import com.boot.entity.ExamResultReportEntity;
import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.CourseDTO;
import com.boot.payload.ExamResultReportDTO;
import com.boot.payload.StudentDTO;
import com.boot.repository.ExamResultReportRepository;
import com.boot.service.ExamResultReportService;

@Service
public class ExamResultReportemplementation implements ExamResultReportService {

	@Autowired
	 private ExamResultReportRepository examResultReportRepository;
	
	@Autowired
	private ModelMapper modelMapper; 
	
	@Override
	public ExamResultReportDTO addExamReport(ExamResultReportDTO examResultReport) {
		
		ExamResultReportEntity examResultReportEntity =this.modelMapper.map(examResultReport,ExamResultReportEntity.class);
		ExamResultReportEntity savedexamResultEntity=this.examResultReportRepository.save(examResultReportEntity);
		return this.modelMapper.map(savedexamResultEntity,ExamResultReportDTO.class);
	}

	@Override
	public List<ExamResultReportDTO> getAllExamReportList() {
		List<ExamResultReportEntity> examResultReportList =this.examResultReportRepository.findAll();
		List<ExamResultReportDTO>  examResultReportListDto = examResultReportList.stream()
				                                    .map(examResultReport->this.modelMapper.map(examResultReport,ExamResultReportDTO.class)) 
				                                    .collect(Collectors.toList());

		return examResultReportListDto;
}

	@Override
	public ExamResultReportDTO getExamReportById(int examResultId) {
		ExamResultReportEntity examreportObj=this.examResultReportRepository.
                findById(examResultId).orElseThrow(()-> new ResourceNotFoundException("examResult","examResultID", examResultId));	          
      
return this.modelMapper.map(examreportObj,ExamResultReportDTO.class);
	}

	@Override
	public void deleteExamReportById(int examResultId) {
		if(this.examResultReportRepository.existsById(examResultId))
		{
			this.examResultReportRepository.deleteById(examResultId);
		}
		else
		{
			throw new ResourceNotFoundException("examResultId","examResultID", examResultId);	
		}
		
	}

	@Override
	public ExamResultReportDTO updateExamReportById(ExamResultReportDTO examResultReport, int examResultId) {
		if(this.examResultReportRepository.existsById(examResultId))
	    {
			ExamResultReportEntity examResultReportObj= this.modelMapper.map(examResultReport, ExamResultReportEntity.class);
			ExamResultReportEntity updatedExamResultReport=this.examResultReportRepository.save(examResultReportObj);
	    	
	    	return this.modelMapper.map(updatedExamResultReport, ExamResultReportDTO.class);
	    	}
	    else
	    {
	    	throw new ResourceNotFoundException("examResult","examResultID",examResultId);
	    }
	}

}
