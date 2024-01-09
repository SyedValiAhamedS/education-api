package com.app.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.education.dto.StudentDTO;
import com.app.education.mapper.StudentMapper;
import com.app.education.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentMapper studentMapper;
	
	public StudentDTO save(StudentDTO studentDTO) {
		return studentMapper
				.convertEntityToDto(studentRepository.save(studentMapper.convertDtoToEntity(studentDTO)));
	}

	public List<StudentDTO> getStudents() {
		return studentMapper.convertListOfEntitiesToDtos(studentRepository.findAll());
	}
	
}