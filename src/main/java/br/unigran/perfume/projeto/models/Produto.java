/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Unigran
 */
@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length = 50)
    private String nome;
    
    private Integer quantidade;
    
    @Column(scale=9, precision=2)
    private Float valor;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="produtoId")
    List<ProdutoVenda> produtoVenda;

    public List<ProdutoVenda> getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(List<ProdutoVenda> produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
