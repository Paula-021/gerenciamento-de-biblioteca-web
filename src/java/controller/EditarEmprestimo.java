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
import models.EmprestimoModel;

/**
 *
 * @author anapa
 */
@WebServlet(name = "EditarEmprestimo", urlPatterns = {"/editar-emprestimo"})
public class EditarEmprestimo extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int idLivro = Integer.parseInt(request.getParameter("idLivro"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        
        Emprestimo emprestimo = new Emprestimo(id,idLivro, idUsuario);
        
        System.out.println("Emprestimo: " + emprestimo.getId());
        request.setAttribute("emprestimos", new EmprestimoModel().selectAll());
        
        request.setAttribute("emprestimo", emprestimo);
        request.setAttribute("caminhoContexto", request.getContextPath());
        
        request.getRequestDispatcher("WEB-INF/pageEditarEmprestimo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int idLivro = Integer.parseInt(request.getParameter("idLvro"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        
        Emprestimo emprestimo = new Emprestimo(id, idLivro, idUsuario);
        new EmprestimoModel().update(emprestimo);
        
        response.sendRedirect("editar-emprestimo");
       
    }

    

}
