/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.LivroModel;

/**
 *
 * @author anapa
 */
@WebServlet(name = "CadastrarLivro", urlPatterns = {"/cadastrar-livro"})
public class CadastrarLivro extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  //carregarPagina
            throws ServletException, IOException {
    
        request.setAttribute("livros", new LivroModel().selectAll());
       
        request.setAttribute("caminhoContexto", request.getContextPath());
        
        request.getRequestDispatcher("WEB-INF/pageCadastrarLivro.jsp").forward(request, response);
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) //enviar dados do frontend para o backend
            throws ServletException, IOException {
        
        //receber os dados que o usuário digitou no formulário
        
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String genero = request.getParameter("genero");
        String isbn = request.getParameter("isbn");
        
        
        Livro livro = new Livro(titulo, autor, genero, isbn);
        
        LivroModel livroModel = new LivroModel();
        livroModel.insert(livro);
        
        response.sendRedirect("cadastrar-livro");
           
       
        //paramos
    }

   
}
