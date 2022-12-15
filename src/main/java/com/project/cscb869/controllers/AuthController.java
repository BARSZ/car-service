package com.project.cscb869.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.User;
import com.project.cscb869.data.repository.AutoServiceRepository;
import com.project.cscb869.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AutoServiceRepository autoServiceRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody ObjectNode objectNode) {
        //AlreadyExistsError AlreadyExistsError = new AlreadyExistsError();
        User user = new User();
        user.setUsername(objectNode.get("username").asText());
        user.setEmail(objectNode.get("email").asText());
        user.setPassword(encoder.encode(objectNode.get("password").asText()));

        AutoService autoService = new AutoService();
        autoService.setName(objectNode.get("name").asText());
        autoService.setUsernameId(user);
        if (userRepository.existsByUsername(user.getUsername())) {

        }
        if (userRepository.existsByEmail(user.getEmail())) {

        }

        /*if (AlreadyExistsError.hasAnyErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(AlreadyExistsError);
        }*/

        // Create new user's account

        autoServiceRepository.save(autoService);
        userRepository.save(user);

        return ResponseEntity.ok("Very nice registration");
    }
}
