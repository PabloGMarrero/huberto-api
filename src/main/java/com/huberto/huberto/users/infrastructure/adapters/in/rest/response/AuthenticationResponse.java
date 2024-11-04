package com.huberto.huberto.users.infrastructure.adapters.in.rest.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class AuthenticationResponse {
    private final String token;
    private final LocalDateTime localDateTime;
    private final String name;
}
