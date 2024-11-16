package com.ntt.elearning.dto.response;

import java.util.Set;

import com.ntt.elearning.entity.Answer_Option;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponse {
    String id;
    String questionText;
    int score;
    Set<Answer_Option> options;
}
