package com.ntt.elearning.service;

import org.springframework.stereotype.Service;

import com.ntt.elearning.dto.request.QuestionRequest;
import com.ntt.elearning.dto.response.QuestionResponse;
import com.ntt.elearning.entity.Answer_Option;
import com.ntt.elearning.entity.Question;
import com.ntt.elearning.exception.AppException;
import com.ntt.elearning.exception.ErrorCode;
import com.ntt.elearning.mapper.QuestionMapper;
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
public class QuestionService {
    QuestionRepository questionRepository;
    QuestionMapper questionMapper;
    AnswerOptionRepository answerOptionRepository;

    public QuestionResponse createQuestion(QuestionRequest request) {
        Question question = questionMapper.toQuestion(request);

        Question savedQuestion = questionRepository.save(question);

        return questionMapper.toQuestionResponse(savedQuestion);
    }

    public void addOptionToQuestion(String questionId, String answerOptionId) {
        var question = questionRepository
                .findById(questionId)
                .orElseThrow(() -> new AppException(ErrorCode.QUESTION_NOT_FOUND));
        Answer_Option option = answerOptionRepository
                .findById(answerOptionId)
                .orElseThrow(() -> new AppException(ErrorCode.ANSWER_OPTION_NOT_FOUND));
        question.getOptions().add(option);
        questionRepository.save(question);
    }

    public void deleteQuestion(String questionId) {
        questionRepository.deleteById(questionId);
    }
}
