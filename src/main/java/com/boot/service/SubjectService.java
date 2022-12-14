package com.boot.service;

import java.util.List;

import com.boot.payload.SubjectDTO;

public interface SubjectService {
	
	
public SubjectDTO addSubject(SubjectDTO subject);
	
	public List<SubjectDTO> getAllSubjectList();
	
	public SubjectDTO getSubjectById(int subjectId);
	
	public void deleteSubjectById(int subjectId);
	
	public SubjectDTO updateSubjectById(SubjectDTO subject,int subjectId);

}
