package com.ntt.elearning.controller;

import java.util.List;

import com.ntt.elearning.dto.request.CourseCreationRequest;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.CourseResponse;
import com.ntt.elearning.repository.CourseRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ntt.elearning.entity.Course;
import com.ntt.elearning.service.CourseService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/courses")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    ApiResponse<CourseResponse> createCourse(@RequestBody @Valid CourseCreationRequest request) {

        return ApiResponse.<CourseResponse>builder()
                .result(courseService.createCourse(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<CourseResponse>> getAllCourses(){
        return ApiResponse.<List<CourseResponse>>builder()
               .result(courseService.getAllCourses())
               .build();
    }
}
