package com.residencial.app.application.service;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.TenantDTO;
import org.springframework.data.domain.Pageable;

public interface TenantService {
    ResultPageWrapper<TenantDTO> getAllTenants(Pageable paging);
    TenantDTO getTenantById(Integer id);
    TenantDTO createTenant(TenantDTO tenantDTO);
    TenantDTO updateTenant(Integer id, TenantDTO tenantDTO);
    void deleteTenant(Integer id);
}