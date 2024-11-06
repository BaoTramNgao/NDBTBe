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
public class Lesson {
    @Id
    String id;

    String title;
    String content;
    String type;

    @ManyToMany
    Set<Video> videos;

    @ManyToMany
    Set<Exercise> exercises;
}
