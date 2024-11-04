package com.huberto.huberto.users.infrastructure.adapters.in.rest.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {
    @NotBlank(message = "Email can not be blank.")
    private String email;

    //@Schema(description = "User password")
    @NotBlank(message = "Password can not be blank.")
    private String password;
}
