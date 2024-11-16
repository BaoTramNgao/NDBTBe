package com.ntt.elearning.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ntt.elearning.dto.request.ExerciseCreationRequest;
import com.ntt.elearning.dto.response.ExerciseResponse;
import com.ntt.elearning.entity.Exercise;
import com.ntt.elearning.entity.Question;
import com.ntt.elearning.exception.AppException;
import com.ntt.elearning.exception.ErrorCode;
import com.ntt.elearning.mapper.ExerciseMapper;
import com.ntt.elearning.repository.ExerciseRepository;
import com.ntt.elearning.repository.QuestionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ExerciseService {
    ExerciseRepository exerciseRepository;
    QuestionRepository questionRepository;
    ExerciseMapper exerciseMapper;

    @PreAuthorize("hasRole('ADMIN')")
    public ExerciseResponse createExercise(ExerciseCreationRequest request) {
        Exercise exercise = exerciseMapper.toExercise(request);
        return exerciseMapper.toExerciseResponse(exerciseRepository.save(exercise));
    }

    public ExerciseResponse getExerciseById(String id) {
        return exerciseMapper.toExerciseResponse(exerciseRepository.findById(id).get());
    }

    public void deleteExercise(String id) {
        exerciseRepository.deleteById(id);
    }

    public void addQuestionToExercise(String exerciseId, String questionId) {
        Exercise exercise = exerciseRepository
                .findById(exerciseId)
                .orElseThrow(() -> new AppException(ErrorCode.EXERCISE_NOT_FOUND));
        Question question = questionRepository
                .findById(questionId)
                .orElseThrow(() -> new AppException(ErrorCode.QUESTION_NOT_FOUND));
        exercise.getQuestions().add(question);
        exerciseRepository.save(exercise);
    }

    public List<ExerciseResponse> getAllExercises() {
        return exerciseRepository.findAll().stream()
                .map(exerciseMapper::toExerciseResponse)
                .toList();
    }
}
