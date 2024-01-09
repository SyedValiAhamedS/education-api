package com.app.education.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.education.dto.CourseDTO;
import com.app.education.dto.StudentDTO;
import com.app.education.service.EducationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Tag(name = "Education", description = "Education management APIs")
@RestController
@RequestMapping("/app")
public class EducationController {

	@Autowired
	EducationService educationService;

	// To add courses for a student
	@Operation(
            summary = "Add courses to a student ID",
            description = "Add courses to a student ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation")
    })
	@PostMapping(value = "/education/{studentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@PathVariable Long studentId, @RequestBody Set<CourseDTO> courses) {

		return Optional.ofNullable(educationService.save(studentId, courses))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Update courses to a student ID",
            description = "Update courses to a student ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	// To update courses for a student
	@PutMapping(value = "/education/{studentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable Long studentId, @RequestBody Set<CourseDTO> courses) {

		return Optional.ofNullable(educationService.update(studentId, courses))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Delete courses to a student ID",
            description = "Add courses to a student ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	// To delete a student
	@DeleteMapping(value = "/education/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable Long studentId) {

		return Optional.ofNullable(educationService.delete(studentId))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Fetch all students enrolled in a course",
            description = "Fetch all students enrolled in a course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	// To retrieve a student by course id.
	@GetMapping(value = "/education/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentDTO>> retrieve(@PathVariable Long courseId) {

		return Optional.ofNullable(educationService.retrieveByCourseId(courseId))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

}