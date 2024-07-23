<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <title>Cadastro de Pessoas</title>
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

      .form-group label {
        font-weight: bold;
      }

      .custom-control-label {
        font-weight: normal;
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
            <a class="nav-link active" href="/pessoas"><i class="bi bi-person"></i> Ver Pessoas</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container mt-4">
      <div class="jumbotron">
        <h1 class="display-4">Nova Pessoa</h1>
        <form>
          <div class="form-group mb-4">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" required>
          </div>
          <div class="form-group mb-4">
            <label for="dataNascimento">Data de Nascimento</label>
            <input type="date" class="form-control" id="dataNascimento" required>
          </div>
          <div class="form-group mb-4">
            <label for="cpf">CPF</label>
            <input type="text" class="form-control" id="cpf" name="cpf" required>
          </div>
          <div class="form-group">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="funcionario" name="funcionario">
              <label class="custom-control-label" for="funcionario">Funcionário</label>
            </div>
          </div>
          <div class="form-group">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="gerente" name="gerente">
              <label class="custom-control-label" for="gerente">Gerente</label>
            </div>
          </div>
          <button type="button" class="btn btn-primary btn-custom" onclick="Cadastro()"><i class="bi bi-save"></i>
            Cadastrar</button>
        </form>
      </div>
    </div>

    <script src="/static/js/pessoa.js"></script>
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