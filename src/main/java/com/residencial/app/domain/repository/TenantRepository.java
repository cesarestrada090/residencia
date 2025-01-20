package com.residencial.app.domain.repository;

import com.residencial.app.domain.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
}