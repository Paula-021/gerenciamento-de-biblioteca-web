<%-- 
    Document   : pageEditarEmprestimo
    Created on : 01/02/2025, 13:40:05
    Author     : anapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Empréstimos</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css"/>

        <style>
            body {
                background-color: #f8f9fa;
                padding: 20px;
            }
            .container {
                max-width: 800px;
                background: #ffffff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                margin-bottom: 20px;
            }
            .form-group input {
                margin-bottom: 10px;
            }
            .table {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Cadastro de Empréstimos</h1>
            <form class="form-group" action="editar-emprestimo" method="POST"> 
                <input value="${emprestimo.id}" name="id" hidden>
                <input class="form-control" value="${emprestimo.idLivro}" placeholder="ID do Livro" name="idLivro" required>
                <input class="form-control" value="${emprestimo.idUsuario}" placeholder="ID do Usuário" name="idUsuario" required>
                <input class="form-control" value="${emprestimo.dataInicio}" placeholder="Data de Início" name="dataInicio" required>
                <input class="form-control" value="${emprestimo.dataFim}" placeholder="Data de Fim" name="dataFim" required>
                <button class="btn btn-primary btn-block mt-3" type="submit">Editar</button>
            </form>

            <table class="table table-bordered table-hover mt-4">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID do Livro</th>
                        <th scope="col">ID do Usuário</th>
                        <th scope="col">Data de Início</th>
                        <th scope="col">Data de Fim</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="emprestimo" items="${emprestimos}">
                        <tr>
                            <td>${emprestimo.idLivro}</td>
                            <td>${emprestimo.idUsuario}</td>
                            <td>${emprestimo.dataInicio}</td>
                            <td>${emprestimo.dataFim}</td>
                            <td>
                                <a class="btn btn-warning btn-sm" href="${caminhoContexto}/editar-emprestimo?id=${emprestimo.id}&idLivro=${emprestimo.idLivro}&idUsuario=${emprestimo.idUsuario}&dataInicio=${emprestimo.dataInicio}&dataFim=${emprestimo.dataFim}">Editar</a>
                                <form action="excluir-emprestimo" method="POST" style="display:inline;">
                                    <input type="hidden" value="${emprestimo.id}" name="id">
                                    <button class="btn btn-danger btn-sm" type="submit">Remover</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" crossorigin="anonymous"></script>
    </body>
</html>

