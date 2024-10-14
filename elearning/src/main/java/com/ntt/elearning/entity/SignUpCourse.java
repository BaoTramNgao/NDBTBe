package com.ntt.elearning.entity;

import java.util.Set;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SignUpCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToMany
    Set<User> userId;

    @ManyToMany
    Set<Course> courseId;
}
