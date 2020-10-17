package com.cuccatti.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cuccatti.example.constants.ApplicationConstants;
import com.cuccatti.example.exception.exceptions.UserNotFoundException;
import com.cuccatti.example.mapper.UserMapper;
import com.cuccatti.example.model.UserEntity;
import com.cuccatti.example.model.dto.UserDTO;
import com.cuccatti.example.repository.UserRepository;
import com.cuccatti.example.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.UserEntityListToUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(String id) throws UserNotFoundException {
    	return userMapper.userEntityToUserDTO(userRepository.findById(id)
    			.orElseThrow(() -> new UserNotFoundException(String.format(ApplicationConstants.USER_NOT_FOUND_EXCEPTION_MESSAGE, id))));
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        UserEntity userEntity = userMapper.userDtoToUserEntity(userDto);
        return userMapper.userEntityToUserDTO(userRepository.insert(userEntity));
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, String id) throws UserNotFoundException {
    	UserEntity userEntity = userRepository.findById(userDto.get_id()).orElseThrow(() -> new UserNotFoundException(String.format(ApplicationConstants.USER_NOT_FOUND_EXCEPTION_MESSAGE, id)));
    	
    	userEntity.setFirstName(userDto.getFirstName());
    	userEntity.setLastName(userDto.getLastName());
    	userEntity.setAge(userDto.getAge());
    	
    	return userMapper.userEntityToUserDTO(userRepository.insert(userEntity));
    	
    	
    }

    @Override
    public void deleteUser(String id) throws UserNotFoundException {
    	userRepository.findById(id)
    	.orElseThrow(() -> new UserNotFoundException(String.format(ApplicationConstants.USER_NOT_FOUND_EXCEPTION_MESSAGE, id)));
        userRepository.deleteById(id);
    }

	@Override
	public List<UserDTO> findByFirstName(String firstName) {
		return userMapper.UserEntityListToUserDTOList(userRepository.findByFirstName(firstName));
	}
}