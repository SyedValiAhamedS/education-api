package com.app.education.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class StudentDTO {
	
	private Long studentId;
	private String name;
	private String emailAddress;
	private Long phoneNumber;
	private String address;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	private Set<CourseDTO> courses = new HashSet<>();
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(Long studentId, String name, String emailAddress, Long phoneNumber, String address, Set<CourseDTO> courses) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseDTO> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", name=" + name + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", courses=" + courses + "]";
	}

}
