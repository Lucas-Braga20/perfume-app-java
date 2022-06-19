/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.casouso;

import br.unigran.perfume.projeto.builder.ClienteBuilder;
import br.unigran.perfume.projeto.models.Cliente;
import br.unigran.perfume.projeto.models.Produto;
import br.unigran.perfume.projeto.persistence.GenericoDAO;
import java.util.List;

/**
 *
 * @author Unigran
 */
public final class ClienteUC {
    private static final GenericoDAO<Cliente> DAO = new GenericoDAO<Cliente>();
    
    public static Cliente salvar(ClienteBuilder clienteBuilder) throws Exception {
        Cliente cliente = clienteBuilder.build();
        cliente = DAO.salvar(cliente, cliente.getId());
        return cliente;
    }
    
    public static Cliente atualizar(ClienteBuilder clienteBuilder, Cliente cliente) throws Exception {
        Cliente anterior = clienteBuilder.build(cliente);
        Cliente atualizado = DAO.salvar(cliente, anterior.getId());
        return atualizado;
    }
    
    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Cliente.class);
    }
    
    public static List<Cliente> listar() throws Exception {
        List<Cliente> clientes = DAO.listar(Cliente.class);
        return clientes;
    }
}
