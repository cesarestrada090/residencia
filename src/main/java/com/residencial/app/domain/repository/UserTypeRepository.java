package com.residencial.app.domain.repository;

import com.residencial.app.domain.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
}