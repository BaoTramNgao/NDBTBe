package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {}
