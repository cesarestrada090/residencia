package com.residencial.app.domain.repository;

import com.residencial.app.domain.entities.DocumentType;
import com.residencial.app.domain.entities.SlotType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotTypeRepository extends JpaRepository<SlotType, Integer> {
}