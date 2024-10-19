package com.ntt.elearning.repository;

import com.ntt.elearning.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvalidTokenRepository extends JpaRepository<InvalidatedToken,String> {
}
