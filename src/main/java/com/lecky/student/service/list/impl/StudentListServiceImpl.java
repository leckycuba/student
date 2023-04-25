
package com.lecky.student.service.list.impl;

import com.lecky.student.mapper.StudentMapper;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.repository.StudentRepository;
import com.lecky.student.service.list.StudentListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class StudentListServiceImpl implements StudentListService{

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
