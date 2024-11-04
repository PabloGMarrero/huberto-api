package com.huberto.huberto.users.domain.ports.in;

import com.huberto.huberto.users.infrastructure.adapters.in.rest.request.LoginRequest;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.request.RegisterRequest;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.response.AuthenticationResponse;

public interface AuthenticationPort {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse login(LoginRequest request);
}
