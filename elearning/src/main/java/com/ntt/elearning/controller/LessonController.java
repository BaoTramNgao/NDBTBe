package com.ntt.elearning.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.elearning.dto.request.LessonCreationRequest;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.LessonResponse;
import com.ntt.elearning.service.LessonService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

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
}
