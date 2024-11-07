package com.ntt.elearning.dto.response;

import com.ntt.elearning.entity.Question;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExerciseResponse {
    String id;
    String title;
    Set<Question> questionIds;
}
