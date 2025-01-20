package com.residencial.app.application.service;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.TenantDTO;
import com.residencial.app.application.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TenantService {
    ResultPageWrapper<TenantDTO> getAllTenants(Pageable paging);
    TenantDTO getTenantById(Integer id);
    List<UserDTO> getUsersByTenantId(Integer tenantId);
    TenantDTO createTenant(TenantDTO tenantDTO);
    TenantDTO updateTenant(Integer id, TenantDTO tenantDTO);
    void deleteTenant(Integer id);
}