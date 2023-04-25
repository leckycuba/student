
package com.lecky.student.service.list.impl;

import static org.mockito.Mockito.when;

import com.lecky.student.mapper.StudentMapper;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.model.entity.StudentEntity;
import com.lecky.student.repository.StudentRepository;
import com.lecky.student.util.TestUtils;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class StudentListServiceImplTest {

	@Mock
	private StudentMapper mapper;
	@Mock
	private StudentRepository repository;
	
	@InjectMocks
	private StudentListServiceImpl service;
	
	@Test
	@DisplayName("Return studentResponse flow when send studentEntity flow")
	void ReturnStudentResponseFlowWhenSendStudentEntityFlow() throws IOException {
		
		List<StudentEntity> studentEntityList = TestUtils.generateList("mock/studentEntityList.json", StudentEntity.class);
		List<StudentResponse> studentResponseList = TestUtils.generateList("mock/studentResponseList.json", StudentResponse.class);
		
		for (int i = 0; i < studentEntityList.size(); i++) {
			when(mapper.studentEntityToStudentResponse(studentEntityList.get(i)))
			  .thenReturn(studentResponseList.get(i));
		}
		
		when(repository.findByStatusTrue())
		  .thenReturn(Flux.fromIterable(studentEntityList));
		
		StepVerifier
		  .create(service.findByStatusTrue())
		  .expectNext(studentResponseList.get(0))
		  .expectNext(studentResponseList.get(1))
		  .verifyComplete();
		  
	}
}
