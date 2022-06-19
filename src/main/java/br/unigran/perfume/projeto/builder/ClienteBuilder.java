/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.builder;

import br.unigran.perfume.projeto.models.Cliente;

/**
 *
 * @author Unigran
 */
public class ClienteBuilder {
    private String nome; 
    
    public ClienteBuilder(String nome) {
        this.nome = nome;
    }
    
    public void validate() throws Exception {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new Exception("Nome não pode ser nulo.");
        }
    }
    
    public Cliente build() throws Exception {
        validate();
        
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        
        return cliente;
    }
    
    public Cliente build(Cliente cliente) throws Exception {
        validate();
        
        cliente.setNome(nome);
        
        return cliente;
    }
}
