package io.github.davidmart7n.multifactorbankguard.model.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
