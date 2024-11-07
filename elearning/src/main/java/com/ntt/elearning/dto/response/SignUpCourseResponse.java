package com.ntt.elearning.dto.response;

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
public class SignUpCourseResponse {
    String id;
    String status;

    Set<User> userId;
    Set<Course> courseId;

}
