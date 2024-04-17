package com.estudosweb.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.teste.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
