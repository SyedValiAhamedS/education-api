package com.app.education.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.education.dto.StudentDTO;
import com.app.education.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Student", description = "Student management APIs")
@RestController
@RequestMapping("/app")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Operation(
            summary = "Enroll new students with/without course",
            description = "Enroll new students with/without course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation")
    })
	// To create student with courses
	@PostMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO) {

		return Optional.ofNullable(studentService.save(studentDTO))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Fetch all students",
            description = "Fetch all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	@GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentDTO>> getStudents() {
		return Optional.ofNullable(studentService.getStudents()).map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}