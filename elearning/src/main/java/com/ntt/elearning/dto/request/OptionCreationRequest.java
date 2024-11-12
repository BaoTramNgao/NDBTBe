package com.ntt.elearning.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionCreationRequest {
    String text;
    String type;
    boolean isCorrect;
}
