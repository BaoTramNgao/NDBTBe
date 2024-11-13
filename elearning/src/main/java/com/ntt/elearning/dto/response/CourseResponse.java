package com.ntt.elearning.dto.response;

import java.util.Set;

import com.ntt.elearning.entity.Exercise;
import com.ntt.elearning.entity.Lesson;
import com.ntt.elearning.entity.UrlFile;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseResponse {
    String id;

    String title;
    String description;
    String status;
    UrlFile thumbnailUrl;
    Set<Lesson> lessons;
    Set<Exercise> exercises;
}
