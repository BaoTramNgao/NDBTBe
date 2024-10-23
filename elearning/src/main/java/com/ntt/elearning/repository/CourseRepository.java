package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.Course;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    boolean existsByCourseTitle(String title);
    Course findCourseById(String id);
}
