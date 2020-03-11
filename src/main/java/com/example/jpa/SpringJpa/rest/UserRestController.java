package com.example.jpa.SpringJpa.rest;

import com.example.jpa.SpringJpa.Exception.ConflictException;
import com.example.jpa.SpringJpa.Service.UserService;
import com.example.jpa.SpringJpa.bean.User;
import com.example.jpa.SpringJpa.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> newUser(@RequestBody User newUser) throws ConflictException {
         try{
             userService.register(newUser);
             return ResponseEntity.status(HttpStatus.CREATED).build();
         } catch (ConflictException e){
             return ResponseEntity.status(HttpStatus.CONFLICT).build();
         }


    }
}
