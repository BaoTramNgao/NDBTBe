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
    String id;

    String text;

    String type;

    boolean is_correct;
}
