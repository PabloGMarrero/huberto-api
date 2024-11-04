package com.huberto.huberto.users.infrastructure.adapters.out;

import com.huberto.huberto.users.domain.model.User;
import com.huberto.huberto.users.domain.ports.out.GetUserProvider;
import com.huberto.huberto.users.infrastructure.adapters.out.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DBGetUser implements GetUserProvider {
    private final UserRepository userRepository;

    public DBGetUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
