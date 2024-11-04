package com.huberto.huberto.users.infrastructure.adapters.out;

import com.huberto.huberto.users.domain.model.User;
import com.huberto.huberto.users.domain.ports.out.CreateUserProvider;
import com.huberto.huberto.users.infrastructure.adapters.out.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DBCreateUser implements CreateUserProvider {
    private final UserRepository userRepository;

    public DBCreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
