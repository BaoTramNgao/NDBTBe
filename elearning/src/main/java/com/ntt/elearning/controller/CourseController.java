package com.ntt.elearning.controller;
import com.ntt.elearning.dto.request.CourseRequest;
import com.ntt.elearning.entity.Course;
import com.ntt.elearning.service.CourseService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    Course createCourse(@RequestBody @Valid CourseRequest Course) {

        return courseService.createCourse(Course);

    }
    @GetMapping("/courses/allCourse")
    List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }


}
