package com.cuccatti.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuccatti.example.exception.exceptions.UserNotFoundException;
import com.cuccatti.example.model.dto.UserDTO;
import com.cuccatti.example.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("getUserById/{id}")
    public UserDTO getUserById(@PathVariable String id) throws UserNotFoundException {
        return userService.getUserById(id);
    }
    
    @GetMapping("getUserByFirstName/{firstName}")
    public List<UserDTO> getUserByFirstName(@PathVariable String firstName) throws UserNotFoundException {
    	return userService.findByFirstName(firstName);
    }

    @PostMapping("/createUser")
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable String id) throws UserNotFoundException {
       return userService.updateUser(userDTO, id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable String id) throws UserNotFoundException {
        userService.deleteUser(id);
    }
    
    @GetMapping("/hello")
    public String hello() {
    	return "Hello";
    }
}

