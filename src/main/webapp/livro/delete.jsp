<!-- Indica características e define o arquivo como um jsp do java e a codificação da página -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Define o tipo do documento -->
<!DOCTYPE html>
<!-- Define o escopo de leitura do html -->
<html>
  <!-- Define o escopo da "cabeça" do site -->
  <head>
    <!-- Define a codificação como utf-8 -->
    <meta charset="utf-8" />
    <!-- Define o título da página -->
    <title>Deletar um Livro</title>
    <!-- Define o estilo de css de bootstrap -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
  </head>
  <!-- Define o corpo do site -->
  <body>
    <!-- Define a divisão principal do site -->
    <main class="container">
      <h1>Deletar um livro</h1>
      <hr />
      <p>tem certeza que deseja deletar o livro<em>"${livro.titulo}"</em>?</p>
      <!-- Define o formulário de exclusão -->
      <form action="/livro/delete" method="post">
        <input type="hidden" name="id" value="${livro.id}" />

        <a href="/livro/list" class="btn btn-info">Voltar</a>
        <input type="submit" value="Deletar" class="btn btn-warning" />
      </form>
    </main>
    <!-- Importação dos scripts do bootstrap -->
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
      integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
      integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
