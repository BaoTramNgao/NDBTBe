package com.ntt.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.elearning.dto.request.QuestionRequest;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.QuestionResponse;
import com.ntt.elearning.service.QuestionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/exercise")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping
    ApiResponse<QuestionResponse> createQuestion(@RequestBody QuestionRequest request) {
        return ApiResponse.<QuestionResponse>builder()
                .result(questionService.createQuestion(request))
                .build();
    }
}
