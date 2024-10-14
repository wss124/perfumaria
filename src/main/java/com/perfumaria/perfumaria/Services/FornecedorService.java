package com.perfumaria.perfumaria.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumaria.perfumaria.Fornecedor;
import com.perfumaria.perfumaria.Repository.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    // Criar ou atualizar um fornecedor
    public Fornecedor salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // Listar todos os fornecedores
    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    // Buscar fornecedor por ID
    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    // Deletar fornecedor por ID
    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }

}
