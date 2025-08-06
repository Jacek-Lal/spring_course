package com.jacek.springboot.cruddemo.rest;

import com.jacek.springboot.cruddemo.model.User;
import com.jacek.springboot.cruddemo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
}

