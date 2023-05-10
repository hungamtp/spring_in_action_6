package com.example.chapter5.user;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public ApplicationUser toUser(PasswordEncoder passwordEncoder) {
        return new ApplicationUser(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}
