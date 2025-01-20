package com.residencial.app.application.service.impl;

import com.residencial.app.application.dto.UserTenantDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.mapper.UserTenantMapper;
import com.residencial.app.application.service.UserTenantService;
import com.residencial.app.domain.entities.UserTenant;
import com.residencial.app.domain.repository.UserTenantRepository;
import com.residencial.app.infrastructure.pagination.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserTenantServiceImpl implements UserTenantService {
    
    private UserTenantRepository userTenantRepository;
    
    private UserTenantMapper userTenantMapper;

    @Override
    public ResultPageWrapper<UserTenantDTO> getAllUserTenants(Pageable pageable) {
        Page<UserTenant> userTenantList = userTenantRepository.findAll(pageable);
        return PaginationUtil.prepareResultWrapper(userTenantList, UserTenantDTO.class);
    }

    @Override
    public UserTenantDTO getUserTenantById(Integer id) {
        return userTenantRepository.findById(id)
                .map(userTenantMapper::toDTO)
                .orElse(null);
    }

    @Override
    public UserTenantDTO createUserTenant(UserTenantDTO userTenantDTO) {
        UserTenant userTenant = userTenantMapper.toEntity(userTenantDTO);
        return userTenantMapper.toDTO(userTenantRepository.save(userTenant));
    }

    @Override
    public UserTenantDTO updateUserTenant(Integer id, UserTenantDTO userTenantDTO) {
        if (userTenantRepository.existsById(id)) {
            UserTenant userTenant = userTenantMapper.toEntity(userTenantDTO);
            userTenant.setId(id);
            return userTenantMapper.toDTO(userTenantRepository.save(userTenant));
        }
        return null;
    }

    @Override
    public void deleteUserTenant(Integer id) {
        userTenantRepository.deleteById(id);
    }
}