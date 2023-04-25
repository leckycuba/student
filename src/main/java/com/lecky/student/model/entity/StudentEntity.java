
package com.lecky.student.model.entity;

import lombok.Data;

import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("STUDENT")
public class StudentEntity {

	private Long id;
	private String name;
	private String lastName;
	private Boolean status;
	private Integer age;
	
}
