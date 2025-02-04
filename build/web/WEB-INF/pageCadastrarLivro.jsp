<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Livros</title>

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
            <h1>Cadastro de Livros</h1>
            <form class="form-group" action="cadastrar-livro" method="POST"> 
                <input class="form-control" placeholder="Digite o título" name="titulo" required>
                <input class="form-control" placeholder="Digite o autor" name="autor" required>
                <input class="form-control" placeholder="Digite o genero" name="genero" required>
                <input class="form-control" placeholder="Digite o isbn" name="isbn" required>
                
                <button class="btn btn-primary btn-block mt-3" type="submit">Cadastrar</button>
            </form>

            <table class="table table-bordered table-hover mt-4">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Título</th>
                        <th scope="col">Autor</th>
                        <th scope="col">Genero</th>
                        <th scope="col">Isbn</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="livro" items="${livros}">
                        <tr>
                            <td>${livro.titulo}</td>
                            <td>${livro.autor}</td>
                            <td>${livro.genero}</td>
                             <td>${livro.isbn}</td>
                            <td>
                                <a class="btn btn-warning btn-sm" href="${caminhoContexto}/editar-livro?id=${livro.id}&titulo=${livro.titulo}&autor=${livro.autor}&genero=${livro.genero}&isbn=${livro.isbn}">Editar</a>
                                <form action="excluir-livro" method="POST" style="display:inline;">
                                    <input type="hidden" value="${livro.id}" name="id">
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




