
package com.lecky.student.service.findbystatusfalse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lecky.student.mapper.StudentMapper;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.model.entity.StudentEntity;
import com.lecky.student.repository.StudentRepository;
import com.lecky.student.util.TestUtils;

import reactor.core.publisher.Flux;

@ExtendWith(MockitoExtension.class)
class StudentFindByStatusFalseServiceImplTest {

	@Mock
	private StudentMapper mapper;
	@Mock
	private StudentRepository repository;
	
	@InjectMocks
	private StudentFindByStatusFalseServiceImpl service;
	
	@Test
	@DisplayName("Return non reactive response when is called")
	void returnNonReactiveResponseWhenIsCalled() throws IOException {
		
		List<StudentEntity> studentEntityList = TestUtils.generateList("mock/studentEntityList.json", StudentEntity.class);
		List<StudentResponse> studentResponseList = TestUtils.generateList("mock/studentResponseList.json", StudentResponse.class);
		
		for (int i = 0; i < studentEntityList.size(); i++) {
			when(mapper.studentEntityToStudentResponse(studentEntityList.get(i)))
			  .thenReturn(studentResponseList.get(i));
		}
		
		when(repository.findByStatusFalse()).thenReturn(Flux.fromIterable(studentEntityList));
		
		assertEquals(studentResponseList, service.findByStatusFalse());
		  
	}
}
