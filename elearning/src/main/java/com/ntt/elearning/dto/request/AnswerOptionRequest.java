package com.ntt.elearning.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer_optionRequest {
    String text;
    boolean isCorrect;
    String type;
}
