/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.casouso;

import br.unigran.perfume.projeto.builder.ProdutoBuilder;
import br.unigran.perfume.projeto.models.Produto;
import br.unigran.perfume.projeto.persistence.GenericoDAO;
import java.util.List;

/**
 *
 * @author Unigran
 */
public final class ProdutoUC {
    private static GenericoDAO<Produto> DAO = new GenericoDAO<Produto>();
    
    public static Produto salvar(ProdutoBuilder produtoBuilder) throws Exception {
        Produto produto = produtoBuilder.build();
        produto = DAO.salvar(produto, produto.getId());
        return produto;
    }
    
    public static Produto atualizar(ProdutoBuilder produtoBuilder, Produto produto) throws Exception {
        Produto anterior = produtoBuilder.build(produto);
        Produto atualizado = DAO.salvar(anterior, anterior.getId());
        return atualizado;
    }
    
    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Produto.class);
    }
    
    public static List<Produto> listar() throws Exception {
        List<Produto> produtos = DAO.listar(Produto.class);
        return produtos;
    }
}
