package com.ntt.elearning.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ntt.elearning.dto.request.LessonCreationRequest;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.LessonResponse;
import com.ntt.elearning.service.LessonService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/courses")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class LessonController {

    @Autowired
    LessonService lessonService;

    @PostMapping("/courses")
    ApiResponse<LessonResponse> createLesson(@RequestBody @Valid LessonCreationRequest request) {
        return ApiResponse.<LessonResponse>builder()
                .result(lessonService.createLesson(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<LessonResponse>> getAllLessonsByCourseId(@RequestParam String courseId) {
        return ApiResponse.<List<LessonResponse>>builder()
               .result(lessonService.getAllLessonsByCourseId(courseId))
               .build();
    }
}
