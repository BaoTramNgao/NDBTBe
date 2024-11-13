package com.ntt.elearning.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ntt.elearning.dto.request.QuestionRequest;
import com.ntt.elearning.dto.response.QuestionResponse;
import com.ntt.elearning.entity.Answer_Option;
import com.ntt.elearning.entity.Question;
import com.ntt.elearning.mapper.QuestionMapper;
import com.ntt.elearning.repository.QuestionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class QuestionService {
    QuestionRepository questionRepository;
    QuestionMapper questionMapper;

    public QuestionResponse createQuestion(QuestionRequest request) {
        Question question = questionMapper.toQuestion(request);

        Set<Answer_Option> answerOptions = new HashSet<>();
        for (Answer_Option optionRequest : request.getOptions()) {
            Answer_Option answerOption = new Answer_Option();
            answerOption.setText(optionRequest.getText());
            answerOption.setCorrect(optionRequest.isCorrect());
            answerOptions.add(answerOption);
        }
        question.setOptions(answerOptions);

        Question savedQuestion = questionRepository.save(question);

        return questionMapper.toQuestionResponse(savedQuestion);
    }
}
