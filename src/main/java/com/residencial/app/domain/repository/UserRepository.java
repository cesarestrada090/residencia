package com.residencial.app.domain.repository;

import com.residencial.app.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByTenantId(Integer tenantId);
}