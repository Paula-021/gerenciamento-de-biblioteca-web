<%-- 
    Document   : pageCadastrarLivro
    Created on : 13/12/2024, 15:37:20
    Author     : anapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
 
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Livros</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
      
        <style>
            table{
                border: 1px solid black;
            }
            td{
                border: 1px solid black;
            }
        </style>
        
    </head>
    
    <body>
        <h1>Cadastro de Livros</h1>
        
        <form action="editar-livro" method="POST"> 
            <input value="${livro.id}" name="id" hidden>

            <input value="${livro.titulo}" placeholder="digite o titulo" name="titulo">
            <input value="${livro.autor}" placeholder="digite o autor" name="autor">
            <input value="${livro.anoPubli}" placeholder="digite o ano de publicação" name="anoPubli">
            <button class="btn btn-outline-primary" type="submit"> Editar </button>
        </form>
        
        <table>
            <thead>
               
                <td>Titulo</td>
                <td>Autor</td>
                <td>Ano publicação</td>
                <td>ações</td>
            </thead>
            
            <c:forEach var="livro" items="${livros}">
                <tr>
                    <td hidden>${livro.id}</td>
                    <td>${livro.titulo}</td>
                    <td>${livro.autor}</td>
                    <td>${livro.anoPubli}</td>
                    <td>
                        <!<!-- botão da edição -->
                        <button class="btn btn-outline-warning"><a href="${caminhoContexto}/editar-livro?id=${livro.id}&titulo=${livro.titulo}&autor=${livro.autor}&anoPubli=${livro.anoPubli}">editar</a></button>
                        
                        <!<!-- botão da exclusão -->
                        <form action="excluir-livro" method="POST">
                            <input hidden value="${livro.id}" name="id">
                            <button class="btn btn-outline-danger" type="submit">remover</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            
            
        </table>
    </body>
</html>
