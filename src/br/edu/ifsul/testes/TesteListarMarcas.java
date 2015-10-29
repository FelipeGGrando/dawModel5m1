/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Felipe
 */
public class TesteListarMarcas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Marca> lista = em.createQuery("from Marca order by id").getResultList();
        for(Marca m : lista) {
            System.out.println("Id: " + m.getId() + " Nome: " +m.getNome());
        }
        em.close();
        emf.close();
    }
}
