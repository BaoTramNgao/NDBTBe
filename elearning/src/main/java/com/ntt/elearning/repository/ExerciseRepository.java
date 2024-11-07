package com.ntt.elearning.repository;

import com.ntt.elearning.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String>{
    Exercise findExerciseById(String exercise);
}
