/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.builder;

import br.unigran.perfume.projeto.models.Cargo;

/**
 *
 * @author Unigran
 */
public class CargoBuilder {
    private String nome;
    
    public CargoBuilder(String nome) {
        this.nome = nome;
    }
    
    public void validate() throws Exception {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new Exception("Nome não pode ser nulo.");
        }
    }
    
    public Cargo build() throws Exception {
        validate();
        
        Cargo cargo = new Cargo();
        cargo.setNome(nome);
        
        return cargo;
    }
    
    public Cargo build(Cargo cargo) throws Exception {
        validate();
        
        cargo.setNome(nome);
        
        return cargo;
    }
}
