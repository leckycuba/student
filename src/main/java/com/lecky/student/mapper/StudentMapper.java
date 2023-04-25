
package com.lecky.student.mapper;

import com.lecky.student.model.dto.StudentRequest;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.model.entity.StudentEntity;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

	public StudentEntity studentRequestToStudentEntity(StudentRequest studentRequest);
	public StudentResponse studentEntityToStudentResponse (StudentEntity studentEntity);
	
}
