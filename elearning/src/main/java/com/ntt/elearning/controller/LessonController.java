package com.ntt.elearning.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.ntt.elearning.dto.request.LessonCreationRequest;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.LessonResponse;
import com.ntt.elearning.service.LessonService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/lessons")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class LessonController {

    LessonService lessonService;

    @PostMapping
    ApiResponse<LessonResponse> createLesson(@RequestBody @Valid LessonCreationRequest request) {
        return ApiResponse.<LessonResponse>builder()
                .result(lessonService.createLesson(request))
                .build();
    }

    @GetMapping("/{courseId}")
    ApiResponse<List<LessonResponse>> getAllLessonsByCourseId(@PathVariable String courseId) {
        return ApiResponse.<List<LessonResponse>>builder()
                .result(lessonService.getAllLessonsByCourseId(courseId))
                .build();
    }
}
