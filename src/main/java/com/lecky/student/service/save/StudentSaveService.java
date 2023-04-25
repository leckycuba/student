
package com.lecky.student.service.save;

import com.lecky.student.model.dto.StudentRequest;

import reactor.core.publisher.Mono;

public interface StudentSaveService {

	public Mono<Long> save(Mono<StudentRequest> estudiante);
	
}
