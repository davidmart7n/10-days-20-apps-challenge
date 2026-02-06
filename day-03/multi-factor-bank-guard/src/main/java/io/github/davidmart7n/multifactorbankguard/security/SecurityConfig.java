package io.github.davidmart7n.multifactorbankguard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import io.github.davidmart7n.multifactorbankguard.repository.UserRepository;

@Configuration
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http

            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth->auth
                .requestMatchers("/api/public/**").permitAll()
                .anyRequest().authenticated()
            )

            .sessionManagement(session->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

            return http.build();
        }
        
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();  
        }   
}
