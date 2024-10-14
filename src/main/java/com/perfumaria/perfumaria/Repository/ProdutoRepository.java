package com.perfumaria.perfumaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfumaria.perfumaria.Perfume;

public interface ProdutoRepository extends JpaRepository<Perfume, Long> {

}
