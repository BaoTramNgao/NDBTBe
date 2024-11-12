package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {}
