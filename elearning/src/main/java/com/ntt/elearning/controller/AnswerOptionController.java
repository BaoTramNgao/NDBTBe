package com.ntt.elearning.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.elearning.dto.request.AnswerOptionRequest;
import com.ntt.elearning.dto.response.AnswerOptionResponse;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.service.OptionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/options")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class AnswerOptionController {
    OptionService answerOptionService;

    @PostMapping
    ApiResponse<AnswerOptionResponse> createAnswerOption(AnswerOptionRequest request) {
        return ApiResponse.<AnswerOptionResponse>builder()
                .result(answerOptionService.createOption(request))
                .build();
    }
}
