package com.cuccatti.example.service;

import java.util.List;

import com.cuccatti.example.exception.exceptions.UserNotFoundException;
import com.cuccatti.example.model.dto.UserDTO;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id) throws UserNotFoundException;
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, String id) throws UserNotFoundException;
    void deleteUser(String id) throws UserNotFoundException;
    List<UserDTO> findByFirstName(String firstName);
}
