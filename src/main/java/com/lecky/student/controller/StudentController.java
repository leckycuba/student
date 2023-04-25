
package com.lecky.student.controller;

import com.lecky.student.model.dto.ErrorResponse;
import com.lecky.student.model.dto.StudentRequest;
import com.lecky.student.model.dto.StudentResponse;
import com.lecky.student.service.list.StudentListService;
import com.lecky.student.service.save.StudentSaveService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/estudiante")
@OpenAPIDefinition(
        info = @Info(
                title = "Api Student",
                version = "1.0",
                description = "API developed for the challenge code",
                contact = @Contact(name = "Lecky", email = "leckycuba@gmail.com")
        )
)
public class StudentController {

	@Autowired
	private StudentSaveService studentSaveService;

	@Autowired
	private StudentListService studentListService;

	@PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@Operation(summary = "Registry endpoint", description = "Endpoint for generate the registry of a student")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "204", description = "Not content", content = @Content(schema = @Schema(implementation = Object.class))),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	        })
	public Mono<ResponseEntity<Object>> save(@Valid @RequestBody Mono<StudentRequest> studentRequest) {
		return studentSaveService.save(studentRequest).map(id -> ResponseEntity.noContent().build());
	}
	
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@Operation(summary = "List endpoint", description = "Endpoint to list the students with active status")
	public Flux<StudentResponse> findByStatusTrue() {
		return studentListService.findByStatusTrue();
	}

}
