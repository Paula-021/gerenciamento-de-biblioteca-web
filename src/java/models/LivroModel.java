/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import daos.LivroDao;
import entities.Livro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class LivroModel {

    public String insert(Livro livro) {
        if(livro.getTitulo().isEmpty() || livro.getAutor().isEmpty() || livro.getAnoPubli().toString().length() < 4) {
            return "Preencha todos os campos. O ano de publicação deve ter 4 números.";
        }else{
        
            new LivroDao().insert(livro);
            return "Livro inserido";
        }
    }

    public ArrayList<Livro> selectAll() {
        return new LivroDao().selectAll();
      
    }

    public void update(Livro livro) {
        new LivroDao().update(livro);
    }

    public void delete(int id) {
        new LivroDao().delete(id);
    }
    
}
