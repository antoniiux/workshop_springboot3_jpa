package com.estudosweb.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.teste.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
