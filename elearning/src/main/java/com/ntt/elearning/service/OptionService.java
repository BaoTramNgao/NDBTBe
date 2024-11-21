package com.ntt.elearning.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ntt.elearning.dto.request.OptionCreationRequest;
import com.ntt.elearning.dto.response.AnswerOptionResponse;
import com.ntt.elearning.dto.response.OptionResponse;
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

    public OptionResponse createOption(OptionCreationRequest request) {
        var option = new Answer_Option();
        option.setId(UUID.randomUUID().toString());
        option.setText(request.getText());
        option.setType(request.getType());
        option.setCorrect(request.isCorrect());
        log.info("request: "+request.isCorrect());
        log.info("option: "+option.isCorrect());
        answerOptionRepository.save(option);
        var optionResponse =new OptionResponse();
        optionResponse.setText(option.getText());
        optionResponse.setType(option.getType());
        optionResponse.setCorrect(option.isCorrect());


        return optionResponse;
    }

    public AnswerOptionResponse getOptionById(String id) {
        return answerOptionMapper.toAnswerOptionResponse(
                answerOptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Option not found")));
    }
}
