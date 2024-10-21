package com.ntt.elearning.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.ntt.elearning.dto.request.CourseCreationRequest;
import com.ntt.elearning.dto.response.CourseResponse;
import com.ntt.elearning.dto.response.UserResponse;
import com.ntt.elearning.entity.Lesson;
import com.ntt.elearning.exception.AppException;
import com.ntt.elearning.exception.ErrorCode;
import com.ntt.elearning.mapper.CourseMapper;
import com.ntt.elearning.mapper.UserMapper;
import com.ntt.elearning.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    CourseMapper courseMapper;
    LessonRepository lessonRepository;

    public Course createCourse(CourseCreationRequest request) {
        if(courseRepository.existsByCourseTitle(request.getTitle()))
            throw  new AppException(ErrorCode.TITLE_EXISTED);
        Course course = courseMapper.toCourse(request);
        HashSet<Lesson> lessons = new HashSet<>();
        for (String title : request.getLessonTitle()) {
            lessonRepository.findBylessonTitle(title).ifPresent(lesson -> lessons.add(lesson));
        }

        course.setLessonId(lessons);
        return courseRepository.save(course);
    }
    /*@PreAuthorize("hasRole('ADMIN')")
    public List<CourseResponse> createCourse() {
        log.info("In method get Users");
        return courseRepository.findAll().stream().map(courseMapper::toCourseResponse).toList();
    }*/
    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
