package com.cuccatti.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cuccatti.example.model.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
	
	@Query("{firstName: ?0}")
	List<UserEntity>findByFirstName(String firstName);
	
	@Query("{'age': {$gt:?0}}")
	List<UserEntity> findAllUsersWithAgeGtSpecifiedNumberDescOrder(byte age);
}