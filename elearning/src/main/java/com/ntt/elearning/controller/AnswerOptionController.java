package com.ntt.elearning.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.elearning.dto.request.OptionCreationRequest;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.OptionResponse;
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
    ApiResponse<OptionResponse> createAnswerOption(@RequestBody  OptionCreationRequest request) {
        return ApiResponse.<OptionResponse>builder()
                .result(answerOptionService.createOption(request))
                .build();
    }
}
