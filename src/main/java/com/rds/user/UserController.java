package com.rds.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> users() {
        logger.info("GET|UserController->users");
        List<UserEntity> users = userRepository.findAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> user(@RequestBody UserDto userDto) {
        logger.info("POST|UserController->user");
        UserEntity newUserEntity = new UserEntity(userDto.getName(), userDto.getEmail(), userDto.getPhone(), userDto.getAddress());
        userRepository.save(newUserEntity);
        return new ResponseEntity("USER_ADDED", HttpStatus.OK);
    }
}
