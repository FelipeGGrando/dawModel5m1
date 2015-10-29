/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.dao.MarcaDAO;
import br.edu.ifsul.modelo.Marca;

/**
 *
 * @author Felipe
 */
public class TesteDaoMarca {

    public static void main(String[] args) throws Exception {
        MarcaDAO dao = new MarcaDAO();
        
        dao.remove(2);
        for (Marca e : dao.getListarTodos()) {
            System.out.println("Id: " + e.getId() + " Nome: " + e.getNome());
        }
    }
}
