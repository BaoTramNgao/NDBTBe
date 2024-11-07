package com.ntt.elearning.dto.response;

import java.util.Set;

import com.ntt.elearning.entity.Course;
import com.ntt.elearning.entity.User;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpCourseResponse {
    String id;
    String status;

    Set<User> userId;
    Set<Course> courseId;
}
