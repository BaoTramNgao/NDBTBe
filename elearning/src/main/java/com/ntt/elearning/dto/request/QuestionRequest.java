package com.ntt.elearning.dto.request;

import java.util.Set;

import com.ntt.elearning.entity.Answer_Option;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequest {
    String questionText;
    String correctAnswer;
    int score;
    Set<Answer_Option> options;
}
