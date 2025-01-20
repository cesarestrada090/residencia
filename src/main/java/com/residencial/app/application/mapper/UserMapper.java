package com.residencial.app.application.mapper;

import com.residencial.app.application.dto.UserDTO;
import com.residencial.app.domain.entities.User;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return MapperUtil.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO dto) {
        return MapperUtil.map(dto, User.class);
    }
}