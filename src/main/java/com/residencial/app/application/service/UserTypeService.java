package com.residencial.app.application.service;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UserDTO;
import com.residencial.app.application.dto.UserTypeDTO;
import org.springframework.data.domain.Pageable;

public interface UserTypeService {
    ResultPageWrapper<UserTypeDTO> getAllUserTypes(Pageable pageable);
    UserTypeDTO getUserTypeById(Integer id);
    UserTypeDTO createUserType(UserTypeDTO userTypeDTO);
    UserTypeDTO updateUserType(Integer id, UserTypeDTO userTypeDTO);
    void deleteUserType(Integer id);
}