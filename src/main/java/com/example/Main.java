package com.example;

import com.example.config.AppConfig;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the UserService bean
        UserService userService = context.getBean(UserService.class);

        // Call the addUser and deleteUser methods
        userService.addUser("John Doe");
        // Call the getUser method
        userService.getUser("John Doe");
        // Call the deleteUser method
        try {
            userService.deleteUser("John Doe");
        } catch (Exception e) { // Handle exception
        }

    }
}
