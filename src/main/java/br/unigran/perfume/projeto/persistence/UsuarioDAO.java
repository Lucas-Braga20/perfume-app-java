/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.persistence;

import br.unigran.perfume.projeto.models.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Unigran
 */
public class UsuarioDAO {
    public List<Funcionario> logar(String username, String senha) throws Exception {
        EntityManager em = SingletonDAO.getInstance().getEM();
        EntityTransaction etx = SingletonDAO.getInstance().getTX();
        
        try {
            List<Funcionario> funcionario = em.createQuery(
                "FROM Funcionario f WHERE f.username = :username AND f.senha = :senha"
            ).setParameter("username", username).setParameter("senha", senha).getResultList();
            
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Funcionario> consultarUsername(String username) throws Exception {
        EntityManager em = SingletonDAO.getInstance().getEM();
        EntityTransaction etx = SingletonDAO.getInstance().getTX();
        
        try {
            List<Funcionario> funcionario = em.createQuery(
                "FROM Funcionario f WHERE f.username = :username"
            ).setParameter("username", username).getResultList();
            
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }
}
