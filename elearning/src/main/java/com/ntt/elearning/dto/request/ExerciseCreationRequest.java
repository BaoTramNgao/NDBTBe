package com.ntt.elearning.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExerciseCreationRequest {
    String title;
    String content;
    int sequence_number;
}
