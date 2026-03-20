package com.SaiAmirthesh.ToDoAPI.controller;

import com.SaiAmirthesh.ToDoAPI.models.User;
import com.SaiAmirthesh.ToDoAPI.repository.UserRepository;
import com.SaiAmirthesh.ToDoAPI.service.UserService;
import com.SaiAmirthesh.ToDoAPI.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil util;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String,String> body){

        String email = body.get("email");
        String password = body.get("password");

        if(userRepository.findByEmail(email).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email already exists");
        }
        userService.createUser(User.builder().email(email).password(password).build());
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");

        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email and password are required"));
        }

        var optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","User not registered"));
        }
        User user = optionalUser.get();
        if(!passwordEncoder.matches(password,user.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Invalid User"));
        }
        String token = util.generateToken(email);
        return ResponseEntity.ok(Map.of("token", token));
    }

}
