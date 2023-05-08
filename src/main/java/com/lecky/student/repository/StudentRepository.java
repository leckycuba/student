
package com.lecky.student.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.lecky.student.model.entity.StudentEntity;

import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<StudentEntity, Long>{

	public Flux<StudentEntity> findByStatusTrue();
	
	public Flux<StudentEntity> findByStatusFalse();
	
}
