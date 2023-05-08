
package com.lecky.student.service.save;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecky.student.mapper.StudentMapper;
import com.lecky.student.model.dto.StudentRequest;
import com.lecky.student.model.entity.StudentEntity;
import com.lecky.student.repository.StudentRepository;

import reactor.core.publisher.Mono;

@Service
public class StudentSaveServiceImpl implements StudentSaveService{

	@Autowired
	private StudentMapper mapper;
	@Autowired
	private StudentRepository repository;

	@Override
	public Mono<Long> save(Mono<StudentRequest>  estudiante) {
		return estudiante
				  .map(mapper::studentRequestToStudentEntity)
				  .flatMap(repository::save)
				  .map(StudentEntity::getId);
	}

}
