package io.github.davidmart7n.multifactorbankguard.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.davidmart7n.multifactorbankguard.model.BankUser;
import io.github.davidmart7n.multifactorbankguard.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public BankUser register(BankUser user) {
        user.set
    }

}
