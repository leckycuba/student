
package com.lecky.student.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.h2.api.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.lecky.student.constant.Constants;
import com.lecky.student.model.dto.ErrorResponse;

import io.r2dbc.spi.R2dbcDataIntegrityViolationException;

@ExtendWith(MockitoExtension.class)
class ErrorHandlerTest {

	@Mock
	private WebExchangeBindException validationException;
	
	private R2dbcDataIntegrityViolationException r2dbcException;
	
	private ErrorHandler errorHandler = new ErrorHandler();

	@Test
	@DisplayName("Return message error when send a validationException")
	void ReturnMessageErrorWhenSendAValidationException() {

		when(validationException.getAllErrors()).thenReturn(Arrays.asList(new ObjectError("name", "message")));
		
		assertEquals(
				ResponseEntity.internalServerError().body(new ErrorResponse(Arrays.asList("message"))),
				errorHandler.validationException(validationException)
		);
		
	}

	@Test
	@DisplayName("Return generic error when primary key is not duplicated")
	void ReturnGenericErrorWhenPrimaryKeyIsNotDuplicated() {
		
		r2dbcException = new R2dbcDataIntegrityViolationException("reason", "123");
		
		assertEquals(
				ResponseEntity.internalServerError().build(),
				errorHandler.r2dbcDataIntegrityViolationException(r2dbcException)
		);
		
	}
	
	@Test
	@DisplayName("Return database error message when primary key is duplicated")
	void ReturnDatabaseErrorMessageWhenPrimaryKeyIsDuplicated() {
		
		r2dbcException = new R2dbcDataIntegrityViolationException("reason", String.valueOf(ErrorCode.DUPLICATE_KEY_1));
		
		assertEquals(
				ResponseEntity.internalServerError().body(new ErrorResponse(Arrays.asList(Constants.DB_ERROR_MESSAGE))),
				errorHandler.r2dbcDataIntegrityViolationException(r2dbcException)
		);
		
	}
	
}
