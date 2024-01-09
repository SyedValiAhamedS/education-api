package com.app.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.education.dto.CourseDTO;
import com.app.education.entity.Course;
import com.app.education.exception.EducationException;
import com.app.education.exception.NotFoundException;
import com.app.education.mapper.CourseMapper;
import com.app.education.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CourseMapper courseMapper;

	public String save(CourseDTO courseDTO) {
		Course course = courseRepository.save(courseMapper.convertDtoToEntity(courseDTO));
		if (null != course) {
			return "SUCCESS";
		}
		throw new EducationException("Error while saving the course details");
	}

	public List<CourseDTO> getCourses() {
		return courseMapper.convertListOfEntitiesToDtos(courseRepository.findAll());
	}

	public String updateByCourseId(Long courseId, CourseDTO courseDTO) {
		if (null != courseRepository.findById(courseId)) {
			Course course = courseRepository.findById(courseId).get();
			course.setName(courseDTO.getName());
			courseRepository.save(course);
			return "SUCCESS";
		}
		throw new NotFoundException("Course not found");
	}

	public String deleteByCourseId(Long courseId) {
		if (null != courseRepository.findById(courseId)) {
			courseRepository.deleteById(courseId);
			return "SUCCESS";
		}
		throw new NotFoundException("Course not found");
	}

	public CourseDTO retrieveByCourseId(Long courseId) {
		if (null != courseRepository.findById(courseId)) {
			return courseMapper.convertEntityToDto(courseRepository.findById(courseId).get());
		}
		throw new NotFoundException("Course not found");
	}

}