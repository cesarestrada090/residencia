package com.residencial.app.infrastructure.repository;

import com.residencial.app.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findUsuarioByUsernameAndPassword(String usuario, String password);
}