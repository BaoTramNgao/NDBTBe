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
    private String id;

    @Column(nullable = false)
    private String text;

    private String type;

    @Column(nullable = false)
    private boolean isCorrect;
}
