/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Felipe
 */
public class TesteRemoverEstado {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
            em = emf.createEntityManager();
            //Recupera o objeto
            Estado e = em.find(Estado.class, 4);
            em.getTransaction().begin();
            em.remove(e); //Remover
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
