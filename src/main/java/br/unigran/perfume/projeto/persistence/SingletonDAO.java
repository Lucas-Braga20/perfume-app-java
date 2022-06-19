/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Unigran
 */
public class SingletonDAO {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction etx;
    private static SingletonDAO dao;
    
    private SingletonDAO() {
        emf = Persistence.createEntityManagerFactory(
            "br.unigran.perfume.projeto_perfume-projeto_jar_1.0-SNAPSHOTPU"
        );
        em = emf.createEntityManager();
        etx = em.getTransaction();
    }
    
    public static SingletonDAO getInstance() {
        if (dao == null) {
            dao = new SingletonDAO();
        }
        return dao;
    }
    
    public EntityManager getEM() {
        return em;
    }
    
    public EntityTransaction getTX() {
        return etx;
    }
}
