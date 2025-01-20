package com.residencial.app.application.service;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UserTenantDTO;
import org.springframework.data.domain.Pageable;

public interface UserTenantService {
    ResultPageWrapper<UserTenantDTO> getAllUserTenants(Pageable pageable);
    UserTenantDTO getUserTenantById(Integer id);
    UserTenantDTO createUserTenant(UserTenantDTO userTenantDTO);
    UserTenantDTO updateUserTenant(Integer id, UserTenantDTO userTenantDTO);
    void deleteUserTenant(Integer id);
}