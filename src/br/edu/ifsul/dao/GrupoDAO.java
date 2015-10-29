/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Grupo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Felipe
 */
public class GrupoDAO implements Serializable{
    private List<Grupo> listarTodos;
    
    public GrupoDAO() {
        
    }
    
    public void persist(Grupo objeto) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.persist(objeto);
            em.getTransaction().commit();
        } catch(Exception e) {
            if(em.getTransaction().isActive() == false ) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public void merge(Grupo objeto) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.merge(objeto);
            em.getTransaction().commit();
        } catch(Exception e) {
            if(em.getTransaction().isActive() == false ) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de merge: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public void remove(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            Grupo objeto = em.find(Grupo.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch(Exception e) {
            if(em.getTransaction().isActive() == false ) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de remoção: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public Grupo getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Grupo.class, id);
        } catch(Exception e) {
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public List<Grupo> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Grupo order by nome").getResultList();
        } catch(Exception e) {
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Grupo> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
