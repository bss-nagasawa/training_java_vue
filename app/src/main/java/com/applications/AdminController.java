package com.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applications.model.Admin;
import com.applications.repository.AdminRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<AdminResponce> getAdmins() {
        return adminRepository.findAll().stream()
                .map(admin -> new AdminResponce(admin.getLoginId(), admin.getAuth()))
                .collect(Collectors.toList());
    }

    public static class AdminResponce {
        private String loginId;
        private int auth;

        public AdminResponce(String loginId, int auth) {
            this.loginId = loginId;
            this.auth = auth;
        }

        public String getLoginId() {
            return loginId;
        }

        public int getAuth() {
            return auth;
        }
    }
}