/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.builder;

import br.unigran.perfume.projeto.models.Produto;

/**
 *
 * @author Unigran
 */
public class ProdutoBuilder {
    private String nome;
    private Integer quantidade;
    private Float valor;
    
    public ProdutoBuilder(String nome, Integer quantidade, Float valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    
    public void validate() throws Exception {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new Exception("Nome não pode ser nulo.");
        }
        
        if (quantidade == null) {
            throw new Exception("Quantidade não pode ser nulo.");
        }
        
        if (valor == null) {
            throw new Exception("Valor não pode ser nulo.");
        }
    }
    
    public Produto build() throws Exception {
        validate();
        
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setValor(valor);
        
        return produto;
    }
    public Produto build(Produto produto) throws Exception {
        validate();
        
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setValor(valor);
        
        return produto;
    }
}
