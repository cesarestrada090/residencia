package com.residencial.app.application.mapper;

import com.residencial.app.application.dto.OrganizationDTO;
import com.residencial.app.domain.entities.Organization;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    public OrganizationDTO toDTO(Organization organization) {
        return MapperUtil.map(organization, OrganizationDTO.class);
    }

    public Organization toEntity(OrganizationDTO dto) {
        return MapperUtil.map(dto, Organization.class);
    }
}