package com.residencial.app.application.service;

import com.residencial.app.application.dto.OrganizationDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrganizationService {
    ResultPageWrapper<OrganizationDTO> getAllOrganizations(Pageable paging);
    OrganizationDTO getOrganizationById(Integer id);
    OrganizationDTO createOrganization(OrganizationDTO organizationDTO);
    OrganizationDTO updateOrganization(Integer id, OrganizationDTO organizationDTO);
    void deleteOrganization(Integer id);
}