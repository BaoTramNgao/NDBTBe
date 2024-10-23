package com.ntt.elearning.entity;

import java.util.Set;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Result {
    @Id
    String id;

    @ManyToMany
    Set<User> user;
    @ManyToMany
    Set<Course> course;
    int score=0;
}
