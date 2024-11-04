package com.huberto.huberto.config.auth;

import com.huberto.huberto.users.domain.ports.out.GetUserProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final GetUserProvider getUserProvider;

    public CustomUserDetailsService(GetUserProvider getUserProvider) {
        this.getUserProvider = getUserProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return UserWrapper.builder().user(getUserProvider.findByEmail(email)).build();
    }
}
