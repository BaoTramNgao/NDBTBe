package com.ntt.elearning.dto.response;

import java.util.Set;

import com.ntt.elearning.entity.Exercise;
import com.ntt.elearning.entity.Video;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonResponse {
    String id;
    String title;
    String description;
    String type;
    Set<Video> videos;
    Set<Exercise> exercises;
}
