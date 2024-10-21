package com.ntt.elearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntt.elearning.entity.Course;
import com.ntt.elearning.repository.CourseRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CourseService {

    CourseRepository courseRepository;

    // public Course createCourse(CourseCreationRequest request) {}

    // public Optional<Course> getCourseById(String id) {
    //     return courseRepository.findById(id);
    // }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
