package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.OptionCreationRequest;
import com.ntt.elearning.dto.response.AnswerOptionResponse;
import com.ntt.elearning.entity.Answer_Option;

@Mapper(componentModel = "spring")
public interface AnswerOptionMapper {
    Answer_Option toAnswerOption(OptionCreationRequest request);

    AnswerOptionResponse toAnswerOptionResponse(Answer_Option answer_option);
}
