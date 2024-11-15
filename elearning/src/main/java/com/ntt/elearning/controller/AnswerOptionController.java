package com.ntt.elearning.controller;

import com.ntt.elearning.dto.request.AnswerOptionRequest;
import com.ntt.elearning.dto.response.AnswerOptionResponse;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.service.OptionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class AnswerOptionController {
    @Autowired
    OptionService answerOptionService;

    @PostMapping("/question/AnswerOption")
    ApiResponse<AnswerOptionResponse> createAnswerOption(AnswerOptionRequest request) {
        return ApiResponse.<AnswerOptionResponse>builder()
                .result(answerOptionService.createOption(request))
                .build();
    }

}
