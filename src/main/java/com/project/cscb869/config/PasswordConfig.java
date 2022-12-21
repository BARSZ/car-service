package com.project.cscb869.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class PasswordConfig {
    private static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    public static String encodePassword(String password) {
        return passwordEncoder().encode(password);
    }
}
