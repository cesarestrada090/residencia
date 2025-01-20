package com.residencial.app.application.mapper;

import com.residencial.app.application.dto.UserDTO;
import com.residencial.app.application.dto.UserTypeDTO;
import com.residencial.app.domain.entities.User;
import com.residencial.app.domain.entities.UserType;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.stereotype.Component;

@Component
public class UserTypeMapper {

    public UserTypeDTO toDTO(UserType userType) {
        return MapperUtil.map(userType, UserTypeDTO.class);
    }

    
    public UserType toEntity(UserTypeDTO userTypeDTO) {
        return MapperUtil.map(userTypeDTO, UserType.class);
    }
}