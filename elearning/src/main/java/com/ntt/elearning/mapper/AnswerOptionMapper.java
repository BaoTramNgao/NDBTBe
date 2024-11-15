package com.ntt.elearning.mapper;

import com.ntt.elearning.dto.request.AnswerOptionRequest;
import com.ntt.elearning.dto.response.AnswerOptionResponse;
import com.ntt.elearning.entity.Answer_Option;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerOptionMapper {
    Answer_Option toAnswerOption(AnswerOptionRequest request);
    AnswerOptionResponse toAnswerOptionResponse(Answer_Option answer_option);
}
