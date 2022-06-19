/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.casouso;

import br.unigran.perfume.projeto.builder.ProdutoBuilder;
import br.unigran.perfume.projeto.builder.ProdutoVendaBuilder;
import br.unigran.perfume.projeto.models.ProdutoVenda;
import br.unigran.perfume.projeto.persistence.GenericoDAO;
import java.util.List;

/**
 *
 * @author Unigran
 */
public final class ProdutoVendaUC {
    private static GenericoDAO<ProdutoVenda> DAO = new GenericoDAO<ProdutoVenda>();
    
    public static ProdutoVenda salvar(ProdutoVendaBuilder produtoVendaBuilder) throws Exception {
        ProdutoVenda produtoVenda = produtoVendaBuilder.build();
        produtoVenda = DAO.salvar(produtoVenda, produtoVenda.getId());
        return produtoVenda;
    }
    
    public static ProdutoVenda atualizar(ProdutoVendaBuilder produtoVendaBuilder, ProdutoVenda produtoVenda) throws Exception {
        ProdutoVenda anterior = produtoVendaBuilder.build(produtoVenda);
        ProdutoVenda atualizado = DAO.salvar(anterior, anterior.getId());
        return atualizado;
    }
    
    public static void remover(Integer id) throws Exception {
        DAO.remover(id, ProdutoVenda.class);
    }
    
    public static List<ProdutoVenda> listar() throws Exception {
        List<ProdutoVenda> produtos = DAO.listar(ProdutoVenda.class);
        return produtos;
    }
}
