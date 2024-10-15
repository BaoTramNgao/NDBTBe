package com.ntt.elearning.dto.request;

import jakarta.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
    @Size(min = 3, message = "USER_INVALID")
    String username;

    @Size(max = 8, message = "USER_INVALID")
    String password;

    String firstName;
    String lastName;
    String dob;
    String email;
}
