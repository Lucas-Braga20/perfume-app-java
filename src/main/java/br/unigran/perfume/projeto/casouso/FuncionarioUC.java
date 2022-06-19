/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.casouso;

import br.unigran.perfume.projeto.builder.FuncionarioBuilder;
import br.unigran.perfume.projeto.models.Funcionario;
import br.unigran.perfume.projeto.persistence.GenericoDAO;
import java.util.List;

/**
 *
 * @author Unigran
 */
public final class FuncionarioUC {
    private static final GenericoDAO<Funcionario> DAO = new GenericoDAO<Funcionario>();
    
    public static Funcionario salvar(FuncionarioBuilder funcionarioBuilder) throws Exception {
        Funcionario funcionario = funcionarioBuilder.build();
        funcionario = DAO.salvar(funcionario, funcionario.getId());
        return funcionario;
    }
    
    public static Funcionario atualizar(FuncionarioBuilder funcionarioBuilder, Funcionario funcionario) throws Exception {
        Funcionario anterior = funcionarioBuilder.build(funcionario);
        Funcionario atualizado = DAO.salvar(funcionario, anterior.getId());
        return atualizado;
    }
    
    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Funcionario.class);
    }
    
    public static List<Funcionario> listar() throws Exception {
        List<Funcionario> funcionarios = DAO.listar(Funcionario.class);
        return funcionarios;
    }
}
