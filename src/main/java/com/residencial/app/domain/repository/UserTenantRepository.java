package com.residencial.app.domain.repository;

import com.residencial.app.domain.entities.UserTenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTenantRepository extends JpaRepository<UserTenant, Integer> {
}