package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ntt.elearning.dto.request.RoleRequest;
import com.ntt.elearning.dto.response.RoleResponse;
import com.ntt.elearning.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
