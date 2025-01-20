package com.residencial.app.application.service.impl;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.TenantDTO;
import com.residencial.app.application.dto.UserDTO;
import com.residencial.app.application.mapper.TenantMapper;
import com.residencial.app.application.mapper.UserMapper;
import com.residencial.app.application.service.TenantService;
import com.residencial.app.domain.entities.Tenant;
import com.residencial.app.domain.repository.TenantRepository;
import com.residencial.app.domain.repository.UserRepository;
import com.residencial.app.infrastructure.pagination.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TenantServiceImpl implements TenantService {
    
    private TenantRepository tenantRepository;
    private UserRepository userRepository;
    private TenantMapper tenantMapper;
    private UserMapper userMapper;

    @Override
    public ResultPageWrapper<TenantDTO> getAllTenants(Pageable paging) {
        Page<Tenant> tenantList = tenantRepository.findAll(paging);
        return PaginationUtil.prepareResultWrapper(tenantList, TenantDTO.class);
    }

    @Override
    public TenantDTO getTenantById(Integer id) {
        return tenantRepository.findById(id)
                .map(tenantMapper::toDTO)
                .orElse(null);
    } 
    @Override
    public List<UserDTO> getUsersByTenantId(Integer tenantId) {
        return userRepository.findByTenantId(tenantId).
                stream().map(userMapper::toDTO).toList();
    }

    @Override
    public TenantDTO createTenant(TenantDTO tenantDTO) {
        Tenant tenant = tenantMapper.toEntity(tenantDTO);
        return tenantMapper.toDTO(tenantRepository.save(tenant));
    }

    @Override
    public TenantDTO updateTenant(Integer id, TenantDTO tenantDTO) {
        if (tenantRepository.existsById(id)) {
            Tenant tenant = tenantMapper.toEntity(tenantDTO);
            tenant.setId(id);
            return tenantMapper.toDTO(tenantRepository.save(tenant));
        }
        return null;
    }

    @Override
    public void deleteTenant(Integer id) {
        tenantRepository.deleteById(id);
    }
}