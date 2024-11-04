package com.huberto.huberto.users.infrastructure.adapters.in.rest.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class RegisterRequest {

    //@Schema(description = "User name")
    private String name;

    //@Schema(description = "User email")
    @NotBlank(message = "Email can not be blank.")
    private String email;

    //@Schema(description = "User password")
    @NotBlank(message = "Password can not be blank.")
    private String password;

}
