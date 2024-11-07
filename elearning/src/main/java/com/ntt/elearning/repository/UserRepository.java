package com.ntt.elearning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    User findUserByUsername(String username);
}
