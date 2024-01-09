package com.app.education.dto;

public class CourseDTO {
	
	private Long courseId;
	private String name;
	
	public CourseDTO() {
	}

	public CourseDTO(Long courseId, String name) {
		super();
		this.courseId = courseId;
		this.name = name;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CourseDTO [courseId=" + courseId + ", name=" + name + "]";
	}
}