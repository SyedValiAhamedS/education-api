package com.app.education.controller;

import java.util.List;
import java.util.Optional;

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
import com.app.education.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Course", description = "Course management APIs")
@RestController
@RequestMapping("/app")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Operation(
            summary = "Create new courses",
            description = "Create new courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation")
    })
	// To create a course
	@PostMapping(value = "/course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody CourseDTO courseDTO) {

		return Optional.ofNullable(courseService.save(courseDTO))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Update existing course",
            description = "Update course by course ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	// To update a course
	@PutMapping(value = "/course/{courseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {

		return Optional.ofNullable(courseService.updateByCourseId(courseId, courseDTO))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Delete existing course",
            description = "Delete course by course ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	// To delete a course
	@DeleteMapping(value = "/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@PathVariable Long courseId) {

		return Optional.ofNullable(courseService.deleteByCourseId(courseId))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Retrieve existing course",
            description = "Retrieve course by course ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	// To retrieve a course
	@GetMapping(value = "/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> retrieve(@PathVariable Long courseId) {

		return Optional.ofNullable(courseService.retrieveByCourseId(courseId))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@Operation(
            summary = "Fetch all courses",
            description = "Fetch all courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	// To view list of courses
	@GetMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CourseDTO>> getCourses() {
		return Optional.ofNullable(courseService.getCourses()).map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}