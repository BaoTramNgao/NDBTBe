package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.Answer_Option;

@Repository
public interface AnswerOptionRepository extends JpaRepository<Answer_Option, String> {}
