package com.ntt.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.elearning.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, String> {
    List<Lesson> findAllByIdLike(String id);
}
