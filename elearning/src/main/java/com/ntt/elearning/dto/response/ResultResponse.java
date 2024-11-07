package com.ntt.elearning.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResultResponse {
    String id;
    String userName;
    String exerciseTitle;
    int score;
}
