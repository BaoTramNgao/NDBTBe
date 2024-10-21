package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.elearning.entity.Lesson;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, String> {
    Optional<Lesson> findBylessonTitle(String lessonTitle);
}
