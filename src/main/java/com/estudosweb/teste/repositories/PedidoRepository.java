package com.estudosweb.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.teste.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
