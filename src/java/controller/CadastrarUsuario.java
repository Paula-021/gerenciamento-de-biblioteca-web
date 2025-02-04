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
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/cadastrar-usuario"})
public class CadastrarUsuario extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("usuarios", new UsuarioModel().selectAll());
        
        request.setAttribute("caminhoContexto", request.getContextPath());
        
        request.getRequestDispatcher("WEB-INF/pageCadastrarUsuario.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //receber os dados que o usuário digitou no formulário
         
         String nome = request.getParameter("nome");
         String endereco = request.getParameter("endereco");
         String email = request.getParameter("email");
         
         Usuario usuario = new Usuario(nome, endereco, email);
         
         UsuarioModel modelUsuario = new UsuarioModel();
         modelUsuario.insert(usuario);
         
         response.sendRedirect("cadastrar-usuario");
    }

   
}
