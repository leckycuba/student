
package com.lecky.student.service.list;

import com.lecky.student.model.dto.StudentResponse;

import reactor.core.publisher.Flux;

public interface StudentListService {

	public Flux<StudentResponse> findByStatusTrue();
	
}