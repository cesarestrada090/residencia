package com.residencial.app.domain.repository;

import com.residencial.app.domain.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}