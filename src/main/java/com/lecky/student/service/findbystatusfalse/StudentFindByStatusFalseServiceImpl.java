
package com.lecky.student.service.findbystatusfalse;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecky.student.mapper.StudentMapper;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.model.entity.StudentEntity;
import com.lecky.student.repository.StudentRepository;

@Service
public class StudentFindByStatusFalseServiceImpl implements StudentFindByStatusFalseService{

	@Autowired
	private StudentMapper mapper;
	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<StudentResponse> findByStatusFalse() {
		
		LinkedList<StudentEntity> studentEntities = new LinkedList<>();
		
		repository
		  .findByStatusFalse()
		  .subscribe(studentEntities::add);
		
		return studentEntities
				 .stream()
				 .map(mapper::studentEntityToStudentResponse)
				 .collect(Collectors.toList());
	}
	

}
