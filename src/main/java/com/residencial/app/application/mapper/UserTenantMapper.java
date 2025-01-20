package com.residencial.app.application.mapper;

import com.residencial.app.application.dto.UserTenantDTO;
import com.residencial.app.domain.entities.UserTenant;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.stereotype.Component;

@Component
public class UserTenantMapper {
    
    public UserTenantDTO toDTO(UserTenant userTenant) {
        return MapperUtil.map(userTenant, UserTenantDTO.class);
    }
    
    public UserTenant toEntity(UserTenantDTO userTenantDTO) {
        return MapperUtil.map(userTenantDTO, UserTenant.class);
    }
}