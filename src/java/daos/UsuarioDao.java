/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connect.Conexao;
import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class UsuarioDao {

    public ArrayList<Usuario> selectAll() {
        String sql = "SELECT * FROM Usuario";
        
        Connection con = null;
        PreparedStatement ps = null;
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"),rs.getString("endereco"), rs.getString("email"));
                usuarios.add(usuario);
            }
                    
                    
        } catch (Exception e) {
        }
        return usuarios;
    }

    public void insert(Usuario usuario) {
        String sql = "INSERT INTO Usuario(nome, endereco, email) VALUES (?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEndereco());
            ps.setString(3, usuario.getEmail());
            
            ps.execute();
            ps.close();
            con.close();
            
        } catch (Exception e) {
        }
    }

    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ?, endereco = ?, email = ? WHERE id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEndereco());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getId());
            
            ps.execute();
            ps.close();;
            con.close();
            
        } catch (Exception e) {
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.execute();
            ps.close();
            con.close();
            
        } catch (Exception e) {
        }
    }

   

    
    
    
}
