package com.ntt.elearning.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonCreationRequest {
    String courseId;
    String title;
    String content;
    String type;
    int numberOfLessons;
    MultipartFile video;
}
