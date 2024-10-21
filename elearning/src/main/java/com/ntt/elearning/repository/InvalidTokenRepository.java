package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.InvalidatedToken;

@Repository
public interface InvalidTokenRepository extends JpaRepository<InvalidatedToken, String> {}
