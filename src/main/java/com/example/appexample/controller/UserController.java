package com.example.appexample.controller;

import com.example.appexample.payload.UserDtoRequest;
import com.example.appexample.payload.UserDtoResponse;
import com.example.appexample.service.serviceImpl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserServiceImpl service;

    public UserController(UserServiceImpl userService) {
        this.service = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDtoResponse> addUser(@RequestBody UserDtoRequest userDto) {
        UserDtoResponse createdUser = service.createUser(userDto);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDtoResponse>> findAllUsers() {
        List<UserDtoResponse> users = service.findAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<UserDtoResponse> findUserByEmail(@RequestParam String email) {
        UserDtoResponse foundUser = service.findUserByEmail(email);

        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> findUserById(@PathVariable Integer id) {
        UserDtoResponse foundUser = service.findUserById(id);

        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

}
