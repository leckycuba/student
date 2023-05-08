
package com.lecky.student.service.findbystatustrue;

import com.lecky.student.model.dto.StudentResponse;

import reactor.core.publisher.Flux;

public interface StudentFindByStatusTrueService {

	public Flux<StudentResponse> findByStatusTrue();
	
}