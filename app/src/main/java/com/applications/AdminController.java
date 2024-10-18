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
    public List<AdminResponse> getAdmins() {
        return adminRepository.findAll().stream()
                .map(admin -> new AdminResponse(admin.getLoginId(), admin.getPassword()))
                .collect(Collectors.toList());
    }

    public static class AdminResponse {
        private String loginId;
        private String password;

        public AdminResponse(String loginId, String password) {
            this.loginId = loginId;
            this.password = password;
        }

        public String getLoginId() {
            return loginId;
        }

        public String getPassword() {
            return password;
        }
    }
}