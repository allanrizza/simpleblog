package com.simpleblog._auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleblog.user.UserEntity;
import com.simpleblog.user.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    AuthenticationManager authenticationManager;
    UserRepository userRepository;

    public AuthenticationController(
        @Autowired AuthenticationManager authenticationManager,
        @Autowired UserRepository userRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data) {
        if(this.userRepository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();
        if(this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        UserEntity user = new UserEntity(data.username(), encryptedPassword, data.email(), data.role());

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
