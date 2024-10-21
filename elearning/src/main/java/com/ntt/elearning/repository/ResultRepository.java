package com.ntt.elearning.Repository;

import com.ntt.elearning.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
