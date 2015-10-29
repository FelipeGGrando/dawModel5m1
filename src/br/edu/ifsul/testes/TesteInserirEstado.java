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
public class TesteInserirEstado {
    public static void main(String[] args) {
        //Responsável por estabelecer a conexão com o banco e criar as EntitysManagers
        EntityManagerFactory emf = null;
        //Gerenciador de entidades
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
            em = emf.createEntityManager();
            Estado e = new Estado();
            e.setNome("Rio Grande do Sul");
            e.setUf("RS");
            em.getTransaction().begin();
            em.persist(e); //Insere
            em.getTransaction().commit();
        } catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().commit();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
