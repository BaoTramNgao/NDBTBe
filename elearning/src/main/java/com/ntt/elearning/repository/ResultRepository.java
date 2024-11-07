package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.elearning.entity.Result;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, String> {
    Optional<Result> findResultById(String resultId);
}
