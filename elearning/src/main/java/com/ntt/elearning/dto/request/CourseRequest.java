package com.ntt.elearning.dto.request;

import com.ntt.elearning.entity.Lesson;
import com.ntt.elearning.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseRequest {
    String id;
    String title;
    String description;
    int sequence_number;
    String status;
    Set<User> userId;
    Set<Lesson> lesson;
}
