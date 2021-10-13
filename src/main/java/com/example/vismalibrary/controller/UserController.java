package com.example.vismalibrary.controller;

import com.example.vismalibrary.model.Users;
import com.example.vismalibrary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/takeBook")
    public ResponseEntity<Users> addReservation(@RequestBody Users user) {
        userService.addReservation(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
