/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connect.Conexao;
import entities.Emprestimo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class EmprestimoDao {

    public ArrayList<Emprestimo> selectAll() {
        String sql = "SELEC * FROM Emprestimo";

        Connection con = null;
        PreparedStatement ps = null;

        ArrayList<Emprestimo> emprestimos = new ArrayList<>();

        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Date dataInicio = rs.getDate("dataInicio");
                LocalDate dataInicioConvertida = dataInicio.toLocalDate();
                Date dataFim = rs.getDate("dataFim");
                LocalDate dataFimConvertida = dataFim.toLocalDate();
                Emprestimo emprestimo = new Emprestimo(rs.getInt("ID"), rs.getInt("idLivro"), rs.getInt("idUsuario"), dataInicioConvertida, dataFimConvertida);
                emprestimos.add(emprestimo);
            }

        } catch (Exception e) {
        }
        return emprestimos;
    }

    public void insert(Emprestimo emprestimo) {
        String sql = "INSERT INTO Emprestimo(idLivro, idUsuario, dataInicio, dataFim) VALUES (?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, emprestimo.getIdLivro());
            ps.setInt(2, emprestimo.getIdUsuario());

            LocalDate dataInicio = emprestimo.getDataInicio();
            Date dataInicioConvertida = Date.valueOf(dataInicio);
            ps.setDate(3, dataInicioConvertida);

            LocalDate dataFim = emprestimo.getDataFim();
            Date dataFimConvertida = Date.valueOf(dataFim);
            ps.setDate(4, dataFimConvertida);

            ps.execute();
            ps.close();

            con.close();

        } catch (Exception e) {
        }
    }

    public void update(Emprestimo emprestimo) {
        String sql = "UPDATE Emprestimo SET idLivro = ?, idUsuario = ? WHERE id = ?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = new Conexao().getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, emprestimo.getIdLivro());
            ps.setInt(2, emprestimo.getIdUsuario());
            ps.setInt(3, emprestimo.getId());

            ps.execute();
            ps.close();;
            con.close();

        } catch (Exception e) {
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Emprestimo WHERE id = ?";

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
