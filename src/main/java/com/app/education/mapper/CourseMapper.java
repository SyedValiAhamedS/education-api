package com.app.education.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.education.dto.CourseDTO;
import com.app.education.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
	@Mapping(source = "courseId", target = "id")
	Course convertDtoToEntity(CourseDTO courseDTO);

	@Mapping(source = "id", target = "courseId")
	CourseDTO convertEntityToDto(Course course);

	List<CourseDTO> convertListOfEntitiesToDtos(List<Course> courses);

	Set<Course> convertListOfDtosToEntities(Set<CourseDTO> courses);

	default Set<Course> mapCourses(Set<CourseDTO> courses) {
		return courses.stream().map(c -> new Course(c.getCourseId(), c.getName())).collect(Collectors.toSet());
	}

}
