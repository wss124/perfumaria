package com.perfumaria.perfumaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfumaria.perfumaria.Entity.Perfume;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {

}
