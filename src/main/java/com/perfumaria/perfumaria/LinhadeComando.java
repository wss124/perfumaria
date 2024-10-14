
package com.perfumaria.perfumaria;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.perfumaria.perfumaria.Entity.Cliente;
import com.perfumaria.perfumaria.Entity.Fornecedor;
import com.perfumaria.perfumaria.Entity.Pedido;
import com.perfumaria.perfumaria.Entity.Perfume;
import com.perfumaria.perfumaria.Services.ClienteService;
import com.perfumaria.perfumaria.Services.FornecedorService;
import com.perfumaria.perfumaria.Services.PedidoService;
import com.perfumaria.perfumaria.Services.PerfumeService;

@Component
public class LinhadeComando implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PerfumeService perfumeService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private FornecedorService fornecedorService;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Loja de Perfumes ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Perfumes");
            System.out.println("3. Gerenciar Pedidos");
            System.out.println("4. Gerenciar Fornecedores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1 -> menuCliente();
                case 2 -> menuPerfume();
                case 3 -> menuPedido();
                case 4 -> menuFornecedor();
                case 0 -> {
                    running = false;
                    System.out.println("Encerrando aplicação...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void menuCliente() {
        System.out.println("\n=== Gerenciamento de Clientes ===");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Remover Cliente");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1 -> adicionarCliente();
            case 2 -> listarClientes();
            case 3 -> atualizarCliente();
            case 4 -> removerCliente();
            default -> System.out.println("Opção inválida!");
        }
    }

    private void adicionarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        clienteService.salvar(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private void listarClientes() {
        List<Cliente> clientes = clienteService.listarTodos();
        clientes.forEach(cliente -> System.out.println(cliente.getId() + " - " + cliente.getNome()));
    }

    private void atualizarCliente() {
        System.out.print("ID do Cliente a atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Optional<Cliente> clienteOpt = clienteService.buscarPorId(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            cliente.setNome(nome);
            clienteService.salvar(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void removerCliente() {
        System.out.print("ID do Cliente a remover: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        clienteService.deletar(id);
        System.out.println("Cliente removido com sucesso!");
    }

    private void menuPerfume() {
        System.out.println("\n=== Gerenciamento de Perfumes ===");
        System.out.println("1. Adicionar Perfume");
        System.out.println("2. Listar Perfumes");
        System.out.println("3. Atualizar Perfume");
        System.out.println("4. Remover Perfume");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1 -> adicionarPerfume();
            case 2 -> listarPerfumes();
            case 3 -> atualizarPerfume();
            case 4 -> removerPerfume();
            default -> System.out.println("Opção inválida!");
        }
    }

    private void adicionarPerfume() {
        System.out.print("Nome do Perfume: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        Perfume perfume = new Perfume();
        perfume.setNome(nome);
        perfume.setPreço(preco);
        perfumeService.salvar(perfume);
        System.out.println("Perfume adicionado com sucesso!");
    }

    private void listarPerfumes() {
        List<Perfume> perfumes = perfumeService.listarTodos();
        perfumes.forEach(perfume -> System.out
                .println(perfume.getId() + " - " + perfume.getNome() + " - R$" + perfume.getPreço()));
    }

    private void atualizarPerfume() {
        System.out.print("ID do Perfume a atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Optional<Perfume> perfumeOpt = perfumeService.buscarPorId(id);
        if (perfumeOpt.isPresent()) {
            Perfume perfume = perfumeOpt.get();
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();
            perfume.setNome(nome);
            perfume.setPreço(preco);
            perfumeService.salvar(perfume);
            System.out.println("Perfume atualizado com sucesso!");
        } else {
            System.out.println("Perfume não encontrado.");
        }
    }

    private void removerPerfume() {
        System.out.print("ID do Perfume a remover: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        perfumeService.deletar(id);
        System.out.println("Perfume removido com sucesso!");
    }

    private void menuPedido() {
        System.out.println("\n=== Gerenciamento de Pedidos ===");
        System.out.println("1. Adicionar Pedido");
        System.out.println("2. Listar Pedidos");
        System.out.println("3. Remover Pedido");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1 -> adicionarPedido();
            case 2 -> listarPedidos();
            case 3 -> removerPedido();
            default -> System.out.println("Opção inválida!");
        }
    }

    private void adicionarPedido() {
        try {
            System.out.print("ID do Cliente: ");
            Long clienteId = scanner.nextLong();
            scanner.nextLine();

            Cliente cliente = clienteService.buscarPorId(clienteId)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

            System.out.print("IDs dos Perfumes (separados por vírgula): ");
            String[] perfumeIds = scanner.nextLine().split(",");

            List<Perfume> perfumes = Arrays.stream(perfumeIds)
                    .map(id -> {
                        try {
                            return perfumeService.buscarPorId(Long.parseLong(id.trim()))
                                    .orElseThrow(() -> new RuntimeException("Perfume não encontrado."));
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("ID de perfume inválido: " + id);
                        }
                    })
                    .toList();

            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setPerfumes(perfumes);
            pedidoService.salvar(pedido);
            System.out.println("Pedido adicionado com sucesso!");

        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private void listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarTodos();
        pedidos.forEach(pedido -> System.out.println(pedido.getId() + " - Cliente: " + pedido.getCliente().getNome()));
    }

    private void removerPedido() {
        System.out.print("ID do Pedido a remover: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        pedidoService.deletar(id);
        System.out.println("Pedido removido com sucesso!");
    }

    private void menuFornecedor() {
        System.out.println("\n=== Gerenciamento de Fornecedores ===");
        System.out.println("1. Adicionar Fornecedor");
        System.out.println("2. Listar Fornecedores");
        System.out.println("3. Remover Fornecedor");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1 -> adicionarFornecedor();
            case 2 -> listarFornecedores();
            case 3 -> removerFornecedor();
            default -> System.out.println("Opção inválida!");
        }
    }

    private void adicionarFornecedor() {
        System.out.print("Nome do Fornecedor: ");
        String nome = scanner.nextLine();
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(nome);
        fornecedorService.salvar(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
    }

    private void listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.listarTodos();
        fornecedores.forEach(fornecedor -> System.out.println(fornecedor.getId() + " - " + fornecedor.getNome()));
    }

    private void removerFornecedor() {
        System.out.print("ID do Fornecedor a ser removido: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        fornecedorService.deletar(id);
        System.out.println("Fornecedor removido com sucesso!");
    }
}