/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.UsuarioModel;

/**
 *
 * @author anapa
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/editar-usuario"})
public class EditarUsuario extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        
        Usuario usuario = new Usuario(nome, endereco, email);
        
        System.out.println("Usuario: " + usuario.getNome());
        request.setAttribute("usuarios", new UsuarioModel().selectAll());
        
        request.setAttribute("usuario", usuario);
        request.setAttribute("caminhoContexto", request.getContextPath());
        
        request.getRequestDispatcher("WEB-INF/pageEditarUsuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        
        Usuario usuario = new Usuario(nome, endereco, email);
        new UsuarioModel().update(usuario);
        
        response.sendRedirect("editar-livro");
       
    }

    

}
