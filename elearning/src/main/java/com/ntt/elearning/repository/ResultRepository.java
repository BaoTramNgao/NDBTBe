package com.ntt.elearning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntt.elearning.entity.Result;

public interface ResultRepository extends JpaRepository<Result, String> {
    Optional<Result> findResultById(String resultId);
}
