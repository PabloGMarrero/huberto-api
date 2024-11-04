package com.huberto.huberto.users.domain.usecases;

import com.huberto.huberto.config.auth.JWTUtils;
import com.huberto.huberto.config.auth.UserWrapper;
import com.huberto.huberto.users.domain.model.User;
import com.huberto.huberto.users.domain.ports.in.AuthenticationPort;
import com.huberto.huberto.users.domain.ports.out.CreateUserProvider;
import com.huberto.huberto.users.domain.ports.out.GetUserProvider;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.request.LoginRequest;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.request.RegisterRequest;
import com.huberto.huberto.users.infrastructure.adapters.in.rest.response.AuthenticationResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationUseCase implements AuthenticationPort {
    private final CreateUserProvider createUserProvider;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final GetUserProvider getUserProvider;

    public AuthenticationUseCase(CreateUserProvider createUserProvider, PasswordEncoder passwordEncoder, JWTUtils jwtUtils, AuthenticationManager authenticationManager, GetUserProvider getUserProvider) {
        this.createUserProvider = createUserProvider;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.getUserProvider = getUserProvider;
    }


    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        final var user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .isActive(true)
                .created(LocalDateTime.now())
                .lastLogin(LocalDateTime.now())
                .build();

        var userRegistered = createUserProvider.create(user);
        var jwt = jwtUtils.generateToken(UserWrapper.builder().user(userRegistered).build());
        return AuthenticationResponse.builder()
                .localDateTime(LocalDateTime.now())
                .name(userRegistered.getName())
                .token(jwt)
                .build();
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = getUserProvider.findByEmail(request.getEmail());

        if (user == null) {
            //throw new AuthException("Invalid email or password"));
        }

        var jwt = jwtUtils.generateToken(UserWrapper.builder().user(user).build());
        return AuthenticationResponse.builder().token(jwt).name(user.getName()).build();
    }
}
