package com.perfumaria.perfumaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfumaria.perfumaria.Entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
