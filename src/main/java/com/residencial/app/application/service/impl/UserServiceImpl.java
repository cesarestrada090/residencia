package com.residencial.app.application.service.impl;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UserDTO;
import com.residencial.app.application.mapper.UserMapper;
import com.residencial.app.application.service.UserService;
import com.residencial.app.domain.entities.User;
import com.residencial.app.domain.repository.UserRepository;
import com.residencial.app.infrastructure.pagination.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultPageWrapper<UserDTO> getAllUsers(Pageable paging) {
        Page<User> userList = userRepository.findAll(paging);
        return PaginationUtil.prepareResultWrapper(userList, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElse(null);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            return userMapper.toDTO(userRepository.save(user));
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}