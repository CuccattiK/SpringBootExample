package com.cuccatti.example.constants;

public class ApplicationConstants {

    private ApplicationConstants() {
        throw new RuntimeException("Should not instantiate constants class");
    }

    public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User with id %s could not be found";
}
