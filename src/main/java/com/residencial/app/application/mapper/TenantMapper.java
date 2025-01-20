package com.residencial.app.application.mapper;

import com.residencial.app.application.dto.TenantDTO;
import com.residencial.app.application.dto.UserDTO;
import com.residencial.app.domain.entities.Tenant;
import com.residencial.app.domain.entities.User;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.stereotype.Component;

@Component
public class TenantMapper {
    
    public TenantDTO toDTO(Tenant tenant) {
        return MapperUtil.map(tenant, TenantDTO.class);
    }

    
    public Tenant toEntity(TenantDTO tenantDTO) {
        return MapperUtil.map(tenantDTO, Tenant.class);
    }
}