package com.cuccatti.example.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cuccatti.example.model.UserEntity;
import com.cuccatti.example.model.dto.UserDTO;

@Mapper
public interface UserMapper {

	UserDTO userEntityToUserDTO(UserEntity optional);
	
	@InheritInverseConfiguration
	UserEntity userDtoToUserEntity(UserDTO userDto);
	
	List<UserDTO> UserEntityListToUserDTOList(List<UserEntity> userEntityList);
}
