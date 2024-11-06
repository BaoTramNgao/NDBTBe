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
public class Question {
    @Id
    private String id;

    private String questionText;

    @OneToMany
    Set<Answer_Option> options;

    @ManyToMany
    Set<Category> categories;

    @Column(nullable = false)
    private String correctAnswer;

    int score;
}
