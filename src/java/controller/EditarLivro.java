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
import models.LivroModel;

/**
 *
 * @author anapa
 */
@WebServlet(name = "EditarLivro", urlPatterns = {"/editar-livro"})
public class EditarLivro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int anoPubli = Integer.parseInt(request.getParameter("anoPubli"));

        Livro livro = new Livro(id, titulo, autor, anoPubli);

        System.out.println("Livro: " + livro.getTitulo());
        request.setAttribute("livros", new LivroModel().selectAll());

        request.setAttribute("livro", livro);
        request.setAttribute("caminhoContexto", request.getContextPath());

        request.getRequestDispatcher("WEB-INF/pageEditarLivro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int anoPubli = Integer.parseInt(request.getParameter("anoPubli"));
        
        Livro livro = new Livro(id, titulo, autor, anoPubli);
        
        new LivroModel().update(livro);
        
        response.sendRedirect("cadastrar-livro");
    }

}
