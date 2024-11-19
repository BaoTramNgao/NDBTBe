package com.ntt.elearning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.UrlFile;

@Repository
public interface UrlRepository extends JpaRepository<UrlFile, String> {
    Optional<UrlFile> findByIdLike(String id);
}
