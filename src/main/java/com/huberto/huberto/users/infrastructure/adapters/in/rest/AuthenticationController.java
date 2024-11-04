package com.huberto.huberto.users.infrastructure.adapters.in.rest;

import com.huberto.huberto.users.domain.ports.in.AuthenticationPort;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.request.LoginRequest;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.request.RegisterRequest;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationPort authenticationPort;

    public AuthenticationController(AuthenticationPort authenticationPort) {
        this.authenticationPort = authenticationPort;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationPort.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationPort.login(request));
    }
}
