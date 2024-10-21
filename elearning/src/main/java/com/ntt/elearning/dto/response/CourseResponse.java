package com.ntt.elearning.dto.response;

import java.util.Set;

import com.ntt.elearning.entity.Lesson;

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
    Set<Lesson> lesson;
}
