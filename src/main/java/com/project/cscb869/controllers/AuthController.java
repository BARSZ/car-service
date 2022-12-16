package com.project.cscb869.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Client;
import com.project.cscb869.data.entity.User;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.data.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AutoServiceRepository autoServiceRepository;
    private final ClientRepository clientRepository;
    private final WorkerRepository workerRepository;
    private final RoleRepository roleRepository;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody ObjectNode objectNode) {
        //AlreadyExistsError AlreadyExistsError = new AlreadyExistsError();
        String typeOfUser = objectNode.get("typeOfUser").asText();

        User user = new User();
        user.setUsername(objectNode.get("username").asText());
        user.setEmail(objectNode.get("email").asText());
        user.setPassword(encoder.encode(objectNode.get("password").asText()));
        user.setAuthorities(new HashSet<>());

        if(Objects.equals(typeOfUser, "Auto Service")){
            AutoService autoService = new AutoService();
            autoService.setName(objectNode.get("name").asText());
            autoService.setUsernameId(user);
            autoServiceRepository.save(autoService);

            user.getAuthorities().add(roleRepository.findById(1L).orElseThrow());

        } else if (Objects.equals(typeOfUser, "Client")) {
            Client client = new Client();
            client.setName(objectNode.get("name").asText());
            client.setUsernameId(user);
            clientRepository.save(client);

            user.getAuthorities().add(roleRepository.findById(3L).orElseThrow());

        } else if (Objects.equals(typeOfUser, "Worker")) {
            Worker worker = new Worker();
            worker.setName(objectNode.get("name").asText());
            worker.setUsernameId(user);
            workerRepository.save(worker);

            user.getAuthorities().add(roleRepository.findById(2L).orElseThrow());
        }

        userRepository.save(user);
        return ResponseEntity.ok("Very nice registration");
    }
}
