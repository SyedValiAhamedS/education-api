package com.app.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.education.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(value = "select s.* from student s inner join stu_courses sc on s.id=sc.student_id where sc.course_id = 1", nativeQuery = true)
	List<Student> retrieveByCourseId(Long courseId);
}