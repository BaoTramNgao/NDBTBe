package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.ntt.elearning.dto.request.UserCreationRequest;
import com.ntt.elearning.dto.request.UserUpdateRequest;
import com.ntt.elearning.dto.response.UserResponse;
import com.ntt.elearning.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
