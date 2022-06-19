/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.casouso;

import br.unigran.perfume.projeto.builder.VendaBuilder;
import br.unigran.perfume.projeto.models.Venda;
import br.unigran.perfume.projeto.persistence.GenericoDAO;
import java.util.List;

/**
 *
 * @author Unigran
 */
public final class VendaUC {
    private static GenericoDAO<Venda> DAO = new GenericoDAO<Venda>();
    
    public static Venda salvar(VendaBuilder vendaBuilder) throws Exception {
        Venda venda = vendaBuilder.build();
        venda = DAO.salvar(venda, venda.getId());
        return venda;
    }
    
    public static Venda atualizar(VendaBuilder vendaBuilder, Venda venda) throws Exception {
        Venda anterior = vendaBuilder.build(venda);
        Venda atualizado = DAO.salvar(anterior, anterior.getId());
        return atualizado;
    }
    
    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Venda.class);
    }
    
    public static List<Venda> listar() throws Exception {
        List<Venda> vendas = DAO.listar(Venda.class);
        return vendas;
    }
}
