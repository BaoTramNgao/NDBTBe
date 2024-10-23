package com.ntt.elearning.dto.response;

import com.ntt.elearning.entity.Video;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonResponse {
    String id;
    String title;
    String description;
    int sequence_number;
    Set<Video> videos;
}
