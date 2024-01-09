package com.app.education.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.education.dto.CourseDTO;
import com.app.education.dto.StudentDTO;
import com.app.education.entity.Student;
import com.app.education.exception.NotFoundException;
import com.app.education.mapper.CourseMapper;
import com.app.education.mapper.StudentMapper;
import com.app.education.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class EducationService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentMapper studentMapper;

	@Autowired
	CourseMapper courseMapper;

	@Transactional
	public String save(Long studentId, Set<CourseDTO> courses) {
		if (null != studentRepository.findById(studentId)) {
			Student student = studentRepository.findById(studentId).get();
			student.setCourses(courseMapper.convertListOfDtosToEntities(courses));
			studentRepository.save(student);
			return "SUCCESS";
		}
		throw new NotFoundException("Student not found");
	}

	@Transactional
	public String update(Long studentId, Set<CourseDTO> courses) {
		if (null != studentRepository.findById(studentId)) {
			Student student = studentRepository.findById(studentId).get();
			student.getCourses().addAll(courseMapper.convertListOfDtosToEntities(courses));
			studentRepository.save(student);
			return "SUCCESS";
		}
		throw new NotFoundException("Student not found");
	}

	@Transactional
	public String delete(Long studentId) {
		if (null != studentRepository.findById(studentId)) {
			studentRepository.deleteById(studentId);
			return "SUCCESS";
		}
		throw new NotFoundException("Student not found");
	}

	@Transactional
	public List<StudentDTO> retrieveByCourseId(Long courseId) {
		List<Student> students = studentRepository.retrieveByCourseId(courseId);
		if(null != students && students.size() > 0) {
			return studentMapper.convertListOfEntitiesToDtos(students);
		}
		throw new NotFoundException("Student with course id not found");
	}

	public List<StudentDTO> getStudents() {
		return studentMapper.convertListOfEntitiesToDtos(studentRepository.findAll());
	}

}