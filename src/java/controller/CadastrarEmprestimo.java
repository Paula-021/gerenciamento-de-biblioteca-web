/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Emprestimo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import models.DataModel;
import models.EmprestimoModel;

/**
 *
 * @author anapa
 */
@WebServlet(name = "CadastrarEmprestimo", urlPatterns = {"/cadastrar-emprestimo"})
public class CadastrarEmprestimo extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("emprestimos", new EmprestimoModel().selectAll());
        request.setAttribute("caminhoContexto", request.getContextPath());
        request.getRequestDispatcher("WEB-INF/pageCadastrarEmprestimo.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //receber os dados que o usuário digitou no formulário
        
        int idLivro = Integer.parseInt(request.getParameter("idLivro"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        LocalDate dataInicio = LocalDate.now();
        DataModel modelData = new DataModel();
        LocalDate dataFim = modelData.calcularDataFim(dataInicio);
        
         
        Emprestimo emprestimo = new Emprestimo(idLivro, idUsuario, dataInicio, dataFim);
        
        EmprestimoModel modelEmprestimo = new EmprestimoModel();
        modelEmprestimo.insert(emprestimo);
        
        response.sendRedirect("cadastrar-emprestimo");
    }

    

}
