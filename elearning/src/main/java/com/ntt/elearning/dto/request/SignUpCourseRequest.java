package com.ntt.elearning.dto.request;

import com.ntt.elearning.entity.Course;
import com.ntt.elearning.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SignUpCourseRequest {
    String courseId;
}
