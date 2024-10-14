package com.perfumaria.perfumaria.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumaria.perfumaria.Perfume;
import com.perfumaria.perfumaria.Repository.PerfumeRepository;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    // Criar ou atualizar um produto
    public Perfume salvar(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    // Listar todos os produtos
    public List<Perfume> listarTodos() {
        return perfumeRepository.findAll();
    }

    // Buscar produto por ID
    public Optional<Perfume> buscarPorId(Long id) {
        return perfumeRepository.findById(id);
    }

    // Deletar produto por ID
    public void deletar(Long id) {
        perfumeRepository.deleteById(id);
    }

}
