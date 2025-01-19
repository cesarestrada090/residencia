package com.residencial.app.domain.service;


import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UsuarioDto;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    UsuarioDto save(UsuarioDto usuarioDto);
    UsuarioDto update(Integer id, UsuarioDto dto);

    UsuarioDto getUserByUserAndPassword(UsuarioDto usuarioDto);
    UsuarioDto getUserById(Integer id);
    ResultPageWrapper<UsuarioDto> getAll(Pageable paging);
}
