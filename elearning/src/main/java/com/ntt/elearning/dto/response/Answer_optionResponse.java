package com.ntt.elearning.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer_optionResponse {
    String id;
    String text;
    boolean isCorrect;
    String type;
}
