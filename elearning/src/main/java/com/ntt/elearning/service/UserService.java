package com.ntt.elearning.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ntt.elearning.Constant.PredefindRole;
import com.ntt.elearning.Constant.StatusConstant;
import com.ntt.elearning.dto.request.SignUpCourseRequest;
import com.ntt.elearning.dto.request.UserCreationRequest;
import com.ntt.elearning.dto.request.UserUpdateRequest;
import com.ntt.elearning.dto.response.UserResponse;
import com.ntt.elearning.entity.Role;
import com.ntt.elearning.entity.User;
import com.ntt.elearning.exception.AppException;
import com.ntt.elearning.exception.ErrorCode;
import com.ntt.elearning.mapper.UserMapper;
import com.ntt.elearning.repository.CourseRepository;
import com.ntt.elearning.repository.RoleRepository;
import com.ntt.elearning.repository.UserRepository;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository repository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;
    CourseRepository courseRepository;

    public UserResponse createUser(UserCreationRequest request) {
        if (repository.existsByUsername(request.getUsername())) throw new AppException(ErrorCode.USER_ALREADY_EXISTED);
        User user = userMapper.toUser(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        HashSet<Role> roles = new HashSet<>();

        roleRepository.findById(PredefindRole.USER_ROLE).ifPresent(roles::add);

        user.setRoles(roles);

        return userMapper.toUserResponse(repository.save(user));
    }

    public UserResponse createTeacher(UserCreationRequest request) {
        if (repository.existsByUsername(request.getUsername())) throw new AppException(ErrorCode.USER_ALREADY_EXISTED);
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(PredefindRole.TEACHER_ROLE).ifPresent(roles::add);

        user.setRoles(roles);
        user.setAccepted(StatusConstant.WAITING);
        return userMapper.toUserResponse(repository.save(user));
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = repository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.updateUser(user, request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));
        return userMapper.toUserResponse(repository.save(user));
    }

    public void deleteUser(String id) {
        User user = repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        repository.delete(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getUsers() {
        log.info("In method get Users");
        return repository.findAll().stream().map(userMapper::toUserResponse).toList();
    }
    ;

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(
                repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public UserResponse signUpCourse(SignUpCourseRequest request) {
        var context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();
        var user = repository.findUserByUsername(username);
        if (user == null) {
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        var course = courseRepository.findById(request.getCourseId());
        if (course == null) {
            throw new AppException(ErrorCode.COURSE_NOT_FOUND);
        }
        user.getCourses().add(course.get());
        return userMapper.toUserResponse(repository.save(user));
    }
}
