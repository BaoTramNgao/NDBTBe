package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.ExerciseCreationRequest;
import com.ntt.elearning.dto.response.ExerciseResponse;
import com.ntt.elearning.entity.Exercise;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    Exercise toExercise(ExerciseCreationRequest request);

    ExerciseResponse toExerciseResponse(Exercise exercise);
}
