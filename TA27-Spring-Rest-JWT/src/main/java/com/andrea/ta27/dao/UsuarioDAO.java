package com.andrea.ta27.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.andrea.ta27.dto.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}