package com.ntt.elearning.dto.response;

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
}
