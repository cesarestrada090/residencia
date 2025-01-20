package com.residencial.app.application.service.impl;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UserTypeDTO;
import com.residencial.app.application.mapper.UserTypeMapper;
import com.residencial.app.application.service.UserTypeService;
import com.residencial.app.domain.entities.UserType;
import com.residencial.app.domain.repository.UserTypeRepository;
import com.residencial.app.infrastructure.pagination.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    
    private UserTypeRepository userTypeRepository;
    
    private UserTypeMapper userTypeMapper;
    @Override
    public ResultPageWrapper<UserTypeDTO> getAllUserTypes(Pageable pageable) {
        Page<UserType> userTypeList = userTypeRepository.findAll(pageable);
        return PaginationUtil.prepareResultWrapper(userTypeList, UserTypeDTO.class);
    }

    @Override
    public UserTypeDTO getUserTypeById(Integer id) {
        return userTypeRepository.findById(id)
                .map(userTypeMapper::toDTO)
                .orElse(null);
    }

    @Override
    public UserTypeDTO createUserType(UserTypeDTO userTypeDTO) {
        UserType userType = userTypeMapper.toEntity(userTypeDTO);
        return userTypeMapper.toDTO(userTypeRepository.save(userType));
    }

    @Override
    public UserTypeDTO updateUserType(Integer id, UserTypeDTO userTypeDTO) {
        if (userTypeRepository.existsById(id)) {
            UserType userType = userTypeMapper.toEntity(userTypeDTO);
            userType.setId(id);
            return userTypeMapper.toDTO(userTypeRepository.save(userType));
        }
        return null;
    }

    @Override
    public void deleteUserType(Integer id) {
        userTypeRepository.deleteById(id);
    }
}