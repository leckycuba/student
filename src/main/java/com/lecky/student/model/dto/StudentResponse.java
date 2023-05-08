
package com.lecky.student.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lecky.student.constant.Constants;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentResponse {

	@JsonProperty(Constants.ID_JSON_PROPERTY)
	@Schema(description = "Id del estudiante", example = "10")
	private Long id;
	
	@JsonProperty(Constants.NAME_JSON_PROPERTY)
	@Schema(description = "Nombre del estudiante", example = "Robert")
	private String name;

	@JsonProperty(Constants.LASTNAME_JSON_PROPERTY)
	@Schema(description = "Apellido del estudiante", example = "Baratheon")
	private String lastName;

	@JsonProperty(Constants.STATUS_JSON_PROPERTY)
	@Schema(description = "Estado del estudiante", example = "true")
	private Boolean status;

	@JsonProperty(Constants.AGE_JSON_PROPERTY)
	@Schema(description = "Edad del estudiante", example = "31")
	private Integer age;
	
}
