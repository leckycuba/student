
package com.lecky.student.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lecky.student.constant.Constants;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class StudentRequest {
	
	@JsonProperty(Constants.ID_JSON_PROPERTY)
	@Positive(message = Constants.ID_POSITIVE_MESSAGE)
	private Long id;
	
	@JsonProperty(Constants.NAME_JSON_PROPERTY)
	@Size(max = 255, message = Constants.NAME_SIZE_MESSAGE)
	@Pattern(regexp = Constants.PATTERN_TEXT, message = Constants.NAME_PATTERN_MESSAGE)
	@NotBlank(message = Constants.NAME_NOTBLANK_MESSAGE)
	private String name;

	@JsonProperty(Constants.LASTNAME_JSON_PROPERTY)
	@Size(max = 255, message = Constants.LASTNAME_SIZE_MESSAGE)
	@Pattern(regexp = Constants.PATTERN_TEXT, message = Constants.LASTNAME_PATTERN_MESSAGE)
	@NotBlank(message = Constants.LASTNAME_NOTBLANK_MESSAGE)
	private String lastName;

	@JsonProperty(Constants.STATUS_JSON_PROPERTY)
	@NotNull(message = Constants.STATUS_NOTNULL_MESSAGE)
	private Boolean status;

	@JsonProperty(Constants.AGE_JSON_PROPERTY)
	@NotNull(message = Constants.AGE_NOTNULL_MESSAGE)
	@PositiveOrZero(message = Constants.AGE_POSITIVEORZERO_MESSAGE)
	@Max(value = 150, message = Constants.AGE_MAX_MESSAGE)
	private Integer age;
	
}