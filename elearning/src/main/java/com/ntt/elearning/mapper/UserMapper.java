package com.ntt.elearning.mapper;

import org.mapstruct.Mapper;

import com.ntt.elearning.dto.request.UserCreationRequest;
import com.ntt.elearning.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
}
