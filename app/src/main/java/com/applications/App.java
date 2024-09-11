package com.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.applications.service.UserService;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

@RestController
class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/message")
    public String hello() {
        if (userService.isDatabaseConnected()) {
            return "データベース接続成功";
        } else {
            return "データベース接続失敗";
        }
    }
}