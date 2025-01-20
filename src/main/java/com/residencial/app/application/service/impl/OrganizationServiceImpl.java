package com.residencial.app.application.service.impl;


import com.residencial.app.application.dto.OrganizationDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.mapper.OrganizationMapper;
import com.residencial.app.application.service.OrganizationService;
import com.residencial.app.domain.entities.Organization;
import com.residencial.app.domain.repository.OrganizationRepository;
import com.residencial.app.infrastructure.pagination.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    
    private OrganizationRepository organizationRepository;
    
    private OrganizationMapper organizationMapper;

    @Override
    public ResultPageWrapper<OrganizationDTO> getAllOrganizations(Pageable paging) {
        Page<Organization> organizationList = organizationRepository.findAll(paging);
        return PaginationUtil.prepareResultWrapper(organizationList, OrganizationDTO.class);
    }

    @Override
    public OrganizationDTO getOrganizationById(Integer id) {
        return organizationRepository.findById(id)
                .map(organizationMapper::toDTO)
                .orElse(null);
    }

    @Override
    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = organizationMapper.toEntity(organizationDTO);
        return organizationMapper.toDTO(organizationRepository.save(organization));
    }

    @Override
    public OrganizationDTO updateOrganization(Integer id, OrganizationDTO organizationDTO) {
        if (organizationRepository.existsById(id)) {
            Organization organization = organizationMapper.toEntity(organizationDTO);
            organization.setId(id);
            return organizationMapper.toDTO(organizationRepository.save(organization));
        }
        return null;
    }

    @Override
    public void deleteOrganization(Integer id) {
        organizationRepository.deleteById(id);
    }
}