package com.ntt.elearning.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ntt.elearning.dto.request.RoleRequest;
import com.ntt.elearning.dto.response.RoleResponse;
import com.ntt.elearning.mapper.RoleMapper;
import com.ntt.elearning.repository.PermissionRepository;
import com.ntt.elearning.repository.RoleRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper mapper;
    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request) {
        var role = mapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return mapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        var role = roleRepository.findAll();
        return role.stream().map(mapper::toRoleResponse).toList();
    }

    public void delete(String id) {
        roleRepository.deleteById(id);
    }
}
