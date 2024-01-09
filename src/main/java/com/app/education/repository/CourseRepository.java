package com.app.education.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.education.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>  {
}