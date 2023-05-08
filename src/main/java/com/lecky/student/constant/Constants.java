
package com.lecky.student.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
	
	public static final String PATTERN_TEXT = "^[\\w\\s-\"\\.ÁÉÍÑÓÚÜáéíñóúü]*$";
	public static final String DB_ERROR_MESSAGE = "No se pudo hacer la grabación porque el id es repetido";
	public static final String NOT_NULL = " no debe ser nulo";
	
	public static final String ID_JSON_PROPERTY = "id";
	public static final String ID_POSITIVE_MESSAGE = ID_JSON_PROPERTY + " debe ser mayor que 0";
	public static final String ID_NOTNULL_MESSAGE = ID_JSON_PROPERTY + NOT_NULL;
	
	public static final String NAME_JSON_PROPERTY = "nombre";
	public static final String NAME_SIZE_MESSAGE = NAME_JSON_PROPERTY + " debe tener máximo 255 caracteres";
	public static final String NAME_PATTERN_MESSAGE = NAME_JSON_PROPERTY + " no permite caracteres extraños";
	public static final String NAME_NOTBLANK_MESSAGE = NAME_JSON_PROPERTY + " no debe estar vacío";
	
	public static final String LASTNAME_JSON_PROPERTY = "apellido";
	public static final String LASTNAME_SIZE_MESSAGE = LASTNAME_JSON_PROPERTY + " debe tener máximo 255 caracteres";
	public static final String LASTNAME_PATTERN_MESSAGE = LASTNAME_JSON_PROPERTY + " no permite caracteres extraños";
	public static final String LASTNAME_NOTBLANK_MESSAGE = LASTNAME_JSON_PROPERTY + " no debe estar vacío";
	
	public static final String STATUS_JSON_PROPERTY = "estado";
	public static final String STATUS_NOTNULL_MESSAGE = STATUS_JSON_PROPERTY + NOT_NULL;

	public static final String AGE_JSON_PROPERTY = "edad";
	public static final String AGE_NOTNULL_MESSAGE = AGE_JSON_PROPERTY + NOT_NULL;
	public static final String AGE_POSITIVEORZERO_MESSAGE = AGE_JSON_PROPERTY + " debe ser mayor que o igual a 0";
	public static final String AGE_MAX_MESSAGE = AGE_JSON_PROPERTY + " debe ser menor que o igual a 150";
	
}