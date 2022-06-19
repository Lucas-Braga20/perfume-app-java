/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.builder;

import br.unigran.perfume.projeto.models.Cargo;
import br.unigran.perfume.projeto.models.Funcionario;

/**
 *
 * @author Unigran
 */
public class FuncionarioBuilder {
    private String nome;
    private Cargo cargo;
    private String username;
    private String senha;
    
    public FuncionarioBuilder(String nome, Cargo cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }
    
    public FuncionarioBuilder username(String username) {
        this.username = username;
        return this;
    }
    
    public FuncionarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }
    
    public void validate() throws Exception {
        if (nome.isEmpty() || nome.isBlank()) {
            throw new Exception("Nome não pode ser nulo.");
        }

        if (cargo == null) {
            throw new Exception("Cargo não pode ser nulo.");
        }
        
        if (username == null) {
            throw new Exception("Username não pode ser nulo.");
        }
        
        if (senha == null) {
            throw new Exception("Senha não pode ser nulo.");
        }
    }
    
    public Funcionario build() throws Exception {
        validate();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setUsername(username);
        funcionario.setSenha(senha);

        return funcionario;
    }
    public Funcionario build(Funcionario funcionario) throws Exception {
        validate();

        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setUsername(username);
        funcionario.setSenha(senha);

        return funcionario;
    }
    
}
