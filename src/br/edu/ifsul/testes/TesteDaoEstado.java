/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.modelo.Estado;

/**
 *
 * @author Felipe
 */
public class TesteDaoEstado {

    public static void main(String[] args) throws Exception {
        EstadoDAO dao = new EstadoDAO();
        
        Estado e1 = new Estado();
        e1.setNome("Minas Gerais");
        e1.setUf("MG");
        dao.persist(e1);
        for(Estado e: dao.getListarTodos()) {
            System.out.println("Id: " + e.getId() + " Nome: " + e.getNome());
        }
        dao.remove(6);
        for(Estado e: dao.getListarTodos()) {
            System.out.println("Id: " + e.getId() + " Nome: " + e.getNome());
        }
    }

}
