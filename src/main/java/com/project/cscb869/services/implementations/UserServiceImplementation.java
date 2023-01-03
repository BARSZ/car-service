package com.project.cscb869.services.implementations;

import com.project.cscb869.data.repository.UserRepository;
import com.project.cscb869.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;
}
