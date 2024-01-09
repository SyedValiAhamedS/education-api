package com.app.education.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.education.dto.StudentDTO;
import com.app.education.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	Student convertDtoToEntity(StudentDTO studentDTO);
	
	@Mapping(source="id",target = "studentId")
	StudentDTO convertEntityToDto(Student student);
	
	List<StudentDTO> convertListOfEntitiesToDtos(List<Student> students);
	
}
