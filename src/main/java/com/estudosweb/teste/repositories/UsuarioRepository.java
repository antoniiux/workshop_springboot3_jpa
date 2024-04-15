package com.estudosweb.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.teste.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
