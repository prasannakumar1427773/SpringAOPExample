package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void addUser(String name) {
        System.out.println("User " + name + " added.");
    }

    public String getUser(String name) {
        System.out.println("Getting user: " + name);
        return name;
    }

    public void deleteUser(String name) {
        System.out.println("User " + name + " deleted.");
        throw new RuntimeException("Delete operation failed!");
    }
}

