/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Unigran
 */
public class GenericoDAO<T> {
    public T salvar(T objeto, Integer id) throws Exception {
        EntityManager em = SingletonDAO.getInstance().getEM();
        EntityTransaction etx = SingletonDAO.getInstance().getTX();
        
        try {
            etx.begin();
            if (id == null) {
                em.persist(objeto);
            } else {
                if (!em.contains(objeto)) {
                    if (em.find(objeto.getClass(), id) == null) {
                        throw new Exception("Erro ao atualizar: " + objeto.getClass().getSimpleName());
                    }
                }
                objeto = em.merge(objeto);
            }
            etx.commit();
        } catch(Exception e) {
            throw e;
        }
        
        return objeto;
    }
    
    public void remover(Integer id, Class<T> classe) throws Exception {
        EntityManager em = SingletonDAO.getInstance().getEM();
        EntityTransaction etx = SingletonDAO.getInstance().getTX();

        try {
            T objeto = em.find(classe, id);
            if (objeto == null) {
                throw new Exception("Não foi possível remover um " + classe.getSimpleName() + " com esse id.");
            }
            etx.begin();
            em.remove(objeto);
            etx.commit();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<T> listar(Class<T> classe) throws Exception {
        EntityManager em = SingletonDAO.getInstance().getEM();
        List<T> objetos = null;

        try {
            objetos = em.createQuery("FROM " + classe.getSimpleName() + " o ").getResultList();
        } catch (Exception e) {
            throw e;
        }

        return objetos;
    }
    
    public T bsucar(Integer id, Class<T> classe) throws Exception {
        EntityManager em = SingletonDAO.getInstance().getEM();
        T objeto = null;

        try {
            objeto = em.find(classe, id);
            if (objeto == null) {
                throw new Exception("Não foi possível achar um " + classe.getSimpleName() + " com esse id.");
            }
        } catch (Exception e) {
            throw e;
        }

        return objeto;
    }
}
