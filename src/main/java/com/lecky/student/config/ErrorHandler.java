
package com.lecky.student.config;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.h2.api.ErrorCode;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.lecky.student.constant.Constants;
import com.lecky.student.model.dto.ErrorResponse;

import io.r2dbc.spi.R2dbcDataIntegrityViolationException;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class ErrorHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ErrorResponse> validationException(WebExchangeBindException validationException) {
    	
    	List<String> errors = validationException
					    	     .getAllErrors()
					    	     .stream()
					    	     .map(DefaultMessageSourceResolvable::getDefaultMessage)
					    	     .collect(Collectors.toList());
    	
    	return ResponseEntity.internalServerError().body(new ErrorResponse(errors));
    	
    }
    
    @ExceptionHandler(R2dbcDataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> r2dbcDataIntegrityViolationException(R2dbcDataIntegrityViolationException r2dbcException){
    	
    	BodyBuilder error = ResponseEntity.internalServerError();
    	
    	return Optional
    	    	  .ofNullable(ErrorCode.DUPLICATE_KEY_1)
    	    	  .map(String::valueOf)
    	    	  .filter(r2dbcException.getSqlState()::equalsIgnoreCase)
    	    	  .map(sqlState -> error.body(new ErrorResponse(Arrays.asList(Constants.DB_ERROR_MESSAGE))))
    	    	  .orElseGet(() -> {
    	    		  log.error(r2dbcException.getMessage());
    	    		  return error.build();
    	    	  });
    	
    }

}