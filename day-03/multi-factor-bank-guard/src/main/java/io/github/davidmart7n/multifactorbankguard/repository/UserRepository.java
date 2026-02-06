package io.github.davidmart7n.multifactorbankguard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.davidmart7n.multifactorbankguard.model.BankUser;

public interface UserRepository extends JpaRepository<BankUser, Long>{
    
    Optional<BankUser> findByUsername(String username);
}
