package com.ntt.elearning.repository;

import com.ntt.elearning.entity.UrlFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlFile,String> {
    Optional<UrlFile> findByIdLike(String id);
}
