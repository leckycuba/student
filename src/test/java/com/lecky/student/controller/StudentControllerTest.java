package com.lecky.student.controller;

import static org.mockito.Mockito.when;

import com.lecky.student.model.dto.StudentRequest;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.service.list.StudentListService;
import com.lecky.student.service.save.StudentSaveService;
import com.lecky.student.util.TestUtils;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
	
	@Mock
	private StudentSaveService studentSaveService;
	@Mock
	private StudentListService studentListService;
	
	@InjectMocks
	private StudentController controller;
	
	@Test
	@DisplayName("Return empty response when recive a request")
	void ReturnEmptyResponseWhenReciveARequest() throws IOException {
		
		StudentRequest studentRequest = TestUtils.generateObject("mock/studentRequest.json", StudentRequest.class);
		
		Mono<StudentRequest> monoStudentRequest = Mono.just(studentRequest);
		
		when(studentSaveService.save(monoStudentRequest)).thenReturn(Mono.just(4L));
		
		StepVerifier
		  .create(controller.save(monoStudentRequest))
		  .expectNext(ResponseEntity.noContent().build())
		  .verifyComplete();
		
	}
	
	@Test
	@DisplayName("Return a list of response when recive a request")
	void ReturnAListOfResponseWhenReciveARequest() throws IOException {
		
		List<StudentResponse> studentResponseList = TestUtils.generateList("mock/studentResponseList.json", StudentResponse.class);
		
		when(studentListService.findByStatusTrue()).thenReturn(Flux.fromIterable(studentResponseList));
		
		StepVerifier
		  .create(controller.findByStatusTrue())
		  .expectNext(studentResponseList.get(0))
		  .expectNext(studentResponseList.get(1))
		  .verifyComplete();
		
	}
	
}
