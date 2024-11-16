package com.ntt.elearning.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.elearning.dto.request.ExerciseCreationRequest;
import com.ntt.elearning.dto.response.ApiResponse;
import com.ntt.elearning.dto.response.ExerciseResponse;
import com.ntt.elearning.service.ExerciseService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/exercise")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class ExerciseController {
    ExerciseService exerciseService;

    @PostMapping
    ApiResponse<ExerciseResponse> createExercise(@RequestBody @Valid ExerciseCreationRequest request) {
        return ApiResponse.<ExerciseResponse>builder()
                .result(exerciseService.createExercise(request))
                .build();
    }
}
