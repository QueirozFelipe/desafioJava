<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <title>Página Inicial</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <style>
      .jumbotron {
        background: #f8f9fa;
        border-radius: .3rem;
        padding: 2rem 2rem;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
      }

      .btn-custom {
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 1.25rem;
      }

      .btn-custom i {
        margin-right: 0.5rem;
      }
    </style>
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/cadastroProjeto"><i class="bi bi-plus-circle"></i> Novo Projeto</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/cadastroPessoa"><i class="bi bi-person-plus"></i> Nova Pessoa</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container mt-4">
      <div class="jumbotron text-center">
        <h1 class="display-4">ProjectPro</h1>
        <p class="lead">Bem-vindo ao ProjectPro, seu gestor de projetos online.</p>
        <hr class="my-4">
        <div class="d-flex justify-content-center">
          <a class="btn btn-primary btn-custom mx-2" href="/projetos" role="button"><i class="bi bi-briefcase"></i> Ver
            Projetos</a>
          <a class="btn btn-primary btn-custom mx-2" href="/pessoas" role="button"><i class="bi bi-person"></i> Ver
            Pessoas</a>
        </div>
      </div>
    </div>

    <script src="/static/js/projeto.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
      integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
      crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
      integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
      crossorigin="anonymous"></script>
  </body>

  </html>