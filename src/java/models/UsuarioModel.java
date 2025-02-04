/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import daos.UsuarioDao;
import entities.Usuario;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class UsuarioModel {


     public ArrayList<Usuario> selectAll()  {
        return new UsuarioDao().selectAll();
    }

    public void insert(Usuario usuario) {
        new UsuarioDao().insert(usuario);
    }

    public void update(Usuario usuario) {
      new UsuarioDao().update(usuario);
    }

    public void delete(int id) {
        new UsuarioDao().delete(id);
    }

   
   
   
   
    

    
  
    
}
