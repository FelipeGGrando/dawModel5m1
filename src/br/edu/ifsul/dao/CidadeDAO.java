/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Felipe
 */
public class CidadeDAO implements Serializable{
    private List<Cidade> listarTodos;
    
    public CidadeDAO() {
        
    }
    
    public void persist(Cidade objeto) throws Exception{
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
    
    public void merge(Cidade objeto) throws Exception{
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
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
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
            Cidade objeto = em.find(Cidade.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
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
    
    public Cidade getObjectById(Integer id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cidade.class, id);
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
    
    public List<Cidade> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Cidade order by nome").getResultList();
        } catch(Exception e) {
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Cidade> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
