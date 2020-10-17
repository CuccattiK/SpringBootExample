package com.cuccatti.example.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cuccatti.example.constants.ApplicationConstants;
import com.cuccatti.example.exception.exceptions.UserNotFoundException;
import com.cuccatti.example.model.UserEntity;
import com.cuccatti.example.repository.UserRepository;
import com.cuccatti.example.service.UserService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	UserService userService;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	private UserController userController;
	
	private static final String ID = "123456789f";
	
	private static final String GET_USER_BY_ID_URL = "getUserById/123456789f";
	
	@BeforeAll
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	void getByIdWorks() throws Exception {
		when(userController.getUserById(anyString())).thenReturn(
				
				
		mockMvc.perform(get(GET_USER_BY_ID_URL))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._id", is("123456789f")));

		assertTrue(user.isPresent());
	}

	@Test
	void getByIdThrowsException() throws Exception {
		when(userController.getUserById(any())).thenThrow(
				new UserNotFoundException(String.format(ApplicationConstants.USER_NOT_FOUND_EXCEPTION_MESSAGE, ID)));
		
		UserNotFoundException exception = assertThrows(
				UserNotFoundException.class, 
				() -> userController.getUserById(ID)
		);
			
		assertAll(
			() -> assertEquals(String.format(ApplicationConstants.USER_NOT_FOUND_EXCEPTION_MESSAGE, ID),
					exception.getMessage()),
			() -> assertTrue(exception instanceof UserNotFoundException)
		);
}

	@Test
	void randomTest() {
		UserEntity user1 = UserEntity
					.builder()
					.firstName("Kyle")
					.lastName("Cuccatti")
					.build();
		UserEntity user2 = UserEntity
					.builder()
					.firstName("Bob")
					.lastName("Tom")
					.build();

		// Create an annonymous implementaton of the Executable interface and perform
		// what we want to do. Java 7.
		assertAll(() -> {
			Executable assertion1 = new Executable() {
				@Override
				public void execute() throws Throwable {
					assertTrue(user1.getFirstName().startsWith("K"));
					assertTrue(user1.getFirstName().equals("Kyle"));
					assertTrue(user2.getLastName().startsWith("T"));
					assertTrue(user2.getLastName().equals("Tom"));
				}
			};
		});

		// Since assertAll takes a functional interface as an argument, we can use
		// lambda here for shorthand.
		assertAll(
			() -> assertTrue(
				user1.getFirstName().startsWith("K") && 
				user1.getFirstName().equals("Kyle") && 
				user2.getLastName().startsWith("T") &&
			    user2.getLastName().equals("Tom")
			)
		);
	}
}
