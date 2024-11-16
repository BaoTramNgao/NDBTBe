package com.ntt.elearning.service;

import org.springframework.stereotype.Service;

import com.ntt.elearning.dto.request.AnswerOptionRequest;
import com.ntt.elearning.dto.response.AnswerOptionResponse;
import com.ntt.elearning.entity.Answer_Option;
import com.ntt.elearning.mapper.AnswerOptionMapper;
import com.ntt.elearning.repository.AnswerOptionRepository;
import com.ntt.elearning.repository.QuestionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OptionService {
    AnswerOptionRepository answerOptionRepository;
    AnswerOptionMapper answerOptionMapper;
    QuestionRepository questionRepository;

    public AnswerOptionResponse createOption(AnswerOptionRequest request) {
        Answer_Option option = answerOptionMapper.toAnswerOption(request);
        option = answerOptionRepository.save(option);
        return answerOptionMapper.toAnswerOptionResponse(option);
    }

    public AnswerOptionResponse getOptionById(String id) {
        return answerOptionMapper.toAnswerOptionResponse(
                answerOptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Option not found")));
    }
}
