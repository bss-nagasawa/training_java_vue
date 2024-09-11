package com.applications.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.applications.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}