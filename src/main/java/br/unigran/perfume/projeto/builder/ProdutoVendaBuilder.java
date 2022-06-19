/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.builder;

import br.unigran.perfume.projeto.models.Produto;
import br.unigran.perfume.projeto.models.ProdutoVenda;
import br.unigran.perfume.projeto.models.Venda;

/**
 *
 * @author Unigran
 */
public class ProdutoVendaBuilder {
    private Float valor;
    private Integer quantidade;
    private Produto produto;
    private Venda venda;
    
    public ProdutoVendaBuilder(Float valor, Integer quantidade, Produto produto, Venda venda) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.produto = produto;
        this.venda = venda;
    }
    
    public void validate() throws Exception {
        if (produto == null) {
            throw new Exception("Produto não pode ser nulo.");
        }
        
        if (venda == null) {
            throw new Exception("Venda não pode ser nulo.");
        }
        
        if (quantidade == null) {
            throw new Exception("Quantidade não pode ser nulo.");
        }
        
        if (valor == null) {
            throw new Exception("Valor não pode ser nulo.");
        }
    }
    
    public ProdutoVenda build() throws Exception {
        validate();
        
        ProdutoVenda produtoVenda = new ProdutoVenda();
        produtoVenda.setProduto(produto);
        produtoVenda.setQuantidade(quantidade);
        produtoVenda.setValor(valor);
        produtoVenda.setVenda(venda);
        
        return produtoVenda;
    }
    public ProdutoVenda build(ProdutoVenda produtoVenda) throws Exception {
        validate();
        
        produtoVenda.setProduto(produto);
        produtoVenda.setQuantidade(quantidade);
        produtoVenda.setValor(valor);
        produtoVenda.setVenda(venda);
        
        return produtoVenda;
    }
}