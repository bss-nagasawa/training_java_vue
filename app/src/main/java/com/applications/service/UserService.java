package com.applications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applications.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean isDatabaseConnected() {
        try {
            userRepository.findAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}