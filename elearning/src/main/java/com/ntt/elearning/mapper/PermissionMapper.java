package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.PermissionRequest;
import com.ntt.elearning.dto.response.PermissionResponse;
import com.ntt.elearning.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
