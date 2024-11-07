package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Course findCourseById(String id);
}
