package io.github.davidmart7n.multifactorbankguard.model.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String secondName;
    private String username;
    private String password;
    private String secretPin;
}
