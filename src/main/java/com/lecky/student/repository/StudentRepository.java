
package com.lecky.student.repository;

import com.lecky.student.model.entity.StudentEntity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<StudentEntity, Long>{

	public Flux<StudentEntity> findByStatusTrue();
	
}
