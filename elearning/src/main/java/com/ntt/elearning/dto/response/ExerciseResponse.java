package com.ntt.elearning.dto.response;

import java.util.Set;

import com.ntt.elearning.entity.Question;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExerciseResponse {
    String id;
    String title;
    String content;
    int sequence_number;
    Set<Question> question;
}
