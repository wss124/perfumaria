package com.perfumaria.perfumaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfumaria.perfumaria.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
