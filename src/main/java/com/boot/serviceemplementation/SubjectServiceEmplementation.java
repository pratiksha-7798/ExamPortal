package com.boot.serviceemplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.StudentEntity;
import com.boot.entity.SubjectEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.StudentDTO;
import com.boot.payload.SubjectDTO;
import com.boot.repository.SubjectRepository;
import com.boot.service.SubjectService;

@Service
public class SubjectServiceEmplementation  implements SubjectService
{
   
	@Autowired
	private SubjectRepository subjectRepository;
     @Autowired
     private ModelMapper modelMapper;
    
	@Override
	public SubjectDTO addSubject(SubjectDTO subject) {
	

		SubjectEntity subjectEntity =this.modelMapper.map(subject,SubjectEntity.class);
		SubjectEntity savedSubjectEntity=this.subjectRepository.save(subjectEntity);
		return this.modelMapper.map(savedSubjectEntity,SubjectDTO.class);
	}

	@Override
	public List<SubjectDTO> getAllSubjectList()
	{
		List<SubjectEntity> subjectList =this.subjectRepository.findAll();
		List<SubjectDTO>  subjectListDto = subjectList.stream()
				                                    .map(subject->this.modelMapper.map(subject, SubjectDTO.class)) 
				                                    .collect(Collectors.toList());

		return subjectListDto;
}

	@Override
	public SubjectDTO getSubjectById(int subjectId)
	{
		SubjectEntity subjectObj=this.subjectRepository.
                findById(subjectId).orElseThrow(()-> new ResourceNotFoundException("subject","subjectID", subjectId));	          
      
return this.modelMapper.map(subjectObj,SubjectDTO.class);
}

	@Override
	public void deleteSubjectById(int subjectId) 
	{	
		if(this.subjectRepository.existsById(subjectId))
	{
		this.subjectRepository.deleteById(subjectId);
	}
	else
	{
		throw new ResourceNotFoundException("subject","subjectID", subjectId);	
	}


	
	}

	@Override
	public SubjectDTO updateSubjectById(SubjectDTO subject, int subjectId) {
		if(this.subjectRepository.existsById(subjectId))
	    {
	    	SubjectEntity subjectObj= this.modelMapper.map(subject, SubjectEntity.class);
	    	SubjectEntity updatedSubject=this.subjectRepository.save(subjectObj);
	    	
	    	return this.modelMapper.map(updatedSubject, SubjectDTO.class);
	    	}
	    else
	    {
	    	throw new ResourceNotFoundException("Subject","SubjectID",subjectId);
	    }

}

	

}
