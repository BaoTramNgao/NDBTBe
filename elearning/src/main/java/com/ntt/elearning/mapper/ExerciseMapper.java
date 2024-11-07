package com.ntt.elearning.mapper;

import com.ntt.elearning.dto.request.ExerciseCreationRequest;
import com.ntt.elearning.dto.response.ExerciseResponse;
import com.ntt.elearning.entity.Exercise;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    Exercise toExercise(ExerciseCreationRequest request);
    ExerciseResponse toExerciseResponse(Exercise exercise);
}
