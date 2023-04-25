
package com.lecky.student.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StudentResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nombre")
	private String name;

	@JsonProperty("apellido")
	private String lastName;

	@JsonProperty("estado")
	private Boolean status;

	@JsonProperty("edad")
	private Integer age;
	
}
