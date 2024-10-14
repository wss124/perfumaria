package com.perfumaria.perfumaria.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumaria.perfumaria.Pedido;
import com.perfumaria.perfumaria.Repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    // Criar ou atualizar um pedido
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Listar todos os pedidos
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido por ID
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Deletar pedido por ID
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

}
