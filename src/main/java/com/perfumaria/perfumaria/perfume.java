package com.perfumaria.perfumaria;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Perfume")
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private double preço;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Pedido> pedidos;

    @ManyToMany
    @JoinTable(name = "perfume_fornecedor", joinColumns = @JoinColumn(name = "perfume_id"), inverseJoinColumns = @JoinColumn(name = "fornecedor_id"))
    Set<Fornecedor> fornecedores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public Set<Fornecedor> getFornecedores() { // Implementação do método
        return fornecedores;
    }

    public void setFornecedores(Set<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

}
