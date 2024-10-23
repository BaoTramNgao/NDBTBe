package com.ntt.elearning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.elearning.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, String> {
    Optional<Lesson> findLessonById(String lessonId);
}
