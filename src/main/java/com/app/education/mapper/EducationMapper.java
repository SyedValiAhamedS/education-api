package com.app.education.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.app.education.dto.StudentDTO;
import com.app.education.entity.Student;

@Mapper(componentModel = "spring")
public interface EducationMapper {
	Student convertDtoToEntity(StudentDTO studentDTO);
	
	StudentDTO convertEntityToDto(Student student);
	
	List<StudentDTO> convertListOfEntitiesToDtos(List<Student> students);
	
}
