package com.ntt.elearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    USER_NOT_FOUND(404, "User not found", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(406, "User not existed", HttpStatus.NOT_FOUND),
    USERNAME_INVALID(407, "User name must have at least 3 characters", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(408, "Password must have at least 8 characters", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(409, "User is not authenticated", HttpStatus.UNAUTHORIZED),
    UNCATEGORIZED_EXCEPTION(410, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED_(411, "You do not has permission", HttpStatus.FORBIDDEN),
    USER_ALREADY_EXISTED(412, "User already exists", HttpStatus.CONFLICT),
    ;
    ;
    int code;
    String message;
    HttpStatusCode httpStatusCode;
}
