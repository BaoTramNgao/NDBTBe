package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.elearning.entity.Lesson;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, String> {
    List<Lesson> findAllByIdLike(String id);
}
