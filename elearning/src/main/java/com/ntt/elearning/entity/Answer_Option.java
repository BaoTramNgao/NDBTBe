package com.ntt.elearning.entity;

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
public class Answer_Option {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String text;

    private String type;

    @Column(nullable = false)
    private boolean isCorrect;
}
