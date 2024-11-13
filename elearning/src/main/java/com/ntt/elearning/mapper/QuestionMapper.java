package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.QuestionRequest;
import com.ntt.elearning.dto.response.QuestionResponse;
import com.ntt.elearning.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toQuestion(QuestionRequest request);

    QuestionResponse toQuestionResponse(Question question);
}
