package com.ntt.elearning.Repository;

import com.ntt.elearning.entity.Course;
import com.ntt.elearning.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
