package com.ntt.elearning.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequest {
    String questionText;
    int score;
    MultipartFile file;
}
