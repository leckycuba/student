
package com.lecky.student.service.save.impl;

import static org.mockito.Mockito.when;

import com.lecky.student.mapper.StudentMapper;
import com.lecky.student.model.dto.StudentRequest;
import com.lecky.student.model.entity.StudentEntity;
import com.lecky.student.repository.StudentRepository;
import com.lecky.student.util.TestUtils;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class StudentSaveServiceImplTest {

	@Mock
	private StudentMapper mapper;
	@Mock
	private StudentRepository repository;
	
	@InjectMocks
	private StudentSaveServiceImpl service;
	
	@Test
	@DisplayName("Return studentResponseEntity when send studentRequest")
	void ReturnStudentEntityWhenSendStudentRequest() throws IOException {
		
		StudentRequest studentRequest = TestUtils.generateObject("mock/studentRequest.json", StudentRequest.class);
		StudentEntity studentEntity = TestUtils.generateObject("mock/studentEntity.json", StudentEntity.class);
		
		when(mapper.studentRequestToStudentEntity(studentRequest)).thenReturn(studentEntity);
		when(repository.save(studentEntity)).thenReturn(Mono.just(studentEntity));
		
		StepVerifier
		  .create(service.save(Mono.just(studentRequest)))
		  .expectNext(studentEntity.getId())
		  .verifyComplete();
		  
	}
}
