package com.residencial.app.application.service;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UserDTO;
import com.residencial.app.domain.entities.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    ResultPageWrapper<UserDTO> getAllUsers(Pageable paging);
    UserDTO getUserById(Integer id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Integer id, UserDTO userDTO);
    void deleteUser(Integer id);
    boolean authenticate(UserDTO userDTO);
}