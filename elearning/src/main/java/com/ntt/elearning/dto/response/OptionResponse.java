package com.ntt.elearning.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OptionResponse {
    String id;
    String text;
    String type;
    boolean isCorrect;
}
