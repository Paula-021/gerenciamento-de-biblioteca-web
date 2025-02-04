/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import daos.EmprestimoDao;
import entities.Emprestimo;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class EmprestimoModel {

    public ArrayList<Emprestimo> selectAll() {
         return new EmprestimoDao().selectAll();
    }

    public void insert(Emprestimo emprestimo) {
        new EmprestimoDao().insert(emprestimo);
    }

    public void update(Emprestimo emprestimo) {
        new EmprestimoDao().update(emprestimo);
    }

    public void delete(int id) {
        new EmprestimoDao().delete(id);
    }

   

    
    
}
