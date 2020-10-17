package com.cuccatti.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class UserDTO {
	
	 private String _id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private int age;
}
