
package com.lecky.student.service.findbystatustrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecky.student.mapper.StudentMapper;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.repository.StudentRepository;

import reactor.core.publisher.Flux;

@Service
public class StudentFindByStatusTrueServiceImpl implements StudentFindByStatusTrueService{

	@Autowired
	private StudentMapper mapper;
	@Autowired
	private StudentRepository repository;
	
	@Override
	public Flux<StudentResponse> findByStatusTrue() {
		return repository
				 .findByStatusTrue()
				 .map(mapper::studentEntityToStudentResponse);
	}

}
