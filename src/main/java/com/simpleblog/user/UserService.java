package com.simpleblog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
