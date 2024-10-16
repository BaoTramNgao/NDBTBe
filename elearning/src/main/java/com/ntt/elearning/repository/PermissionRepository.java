package com.ntt.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.elearning.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
