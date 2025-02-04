/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connect.Conexao;
import entities.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anapa
 */
public class LivroDao {

    public void insert(Livro livro) {
        String sql = "INSERT INTO Livro (titulo, autor, genero, isbn)values (?, ?, ?,?)";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getGenero());
            ps.setString(4, livro.getIsbn());

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            //throw new Exception("Não foi possível inserir o Livro corretamente");
            ex.printStackTrace();
        }

    }

    public ArrayList<Livro> selectAll() {
        String sql = "SELECT * FROM livro";

        Connection con = null;
        PreparedStatement ps = null;

        ArrayList<Livro> livros = new ArrayList<>();
        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("ID"), rs.getString("titulo"), rs.getString("autor"), rs.getString("genero"), rs.getString("isbn"));
                livros.add(livro);
            }
        } catch (Exception e) {
        }
        
        return livros;

    }

    public void update(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, genero = ?, isbn = ? WHERE id = ?";
        try {
            Connection con = new Conexao().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getGenero());
            ps.setString(4, livro.getIsbn());
            ps.setInt(5, livro.getId());

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM Livro WHERE id = ?";
        Connection con;
        try {
            con = new Conexao().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
