/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.omg.CORBA.PERSIST_STORE;

/**
 *
 * @author Felipe
 */
public class TesteListarCidades {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5m1-ModelPU");
        EntityManager em = emf.createEntityManager();
        String jpql = "from Cidade order by id";
        // String jpql = "from Cidade order by estado.nome";
        // String jpql = "from Cidade where estado.uf = 'SC' order by nome";
        List<Cidade> lista = em.createQuery(jpql).getResultList();
        for (Cidade c : lista) {
            System.out.println("Id: " + c.getId() + " Nome: " + c.getNome() + 
                    " Estado: " + c.getEstado().getNome() + " UF: " + c.getEstado().getUf());
        }
        em.close();
        emf.close();
    }
}
