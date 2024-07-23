<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <title>Cadastro de Projetos</title>
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

      .navbar-nav .nav-link.active {
        font-weight: bold;
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
          <li class="nav-item active">
            <a class="nav-link" href="/projetos"><i class="bi bi-file-earmark-text"></i> Ver Projetos</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container mt-4">
      <div class="jumbotron">
        <h1 class="display-4">Cadastro de Projeto</h1>
        <form>
          <div class="form-group mb-4">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" required>
          </div>
          <div class="form-group mb-4">
            <label for="idGerente">Id Gerente Responsável</label>
            <input type="text" class="form-control" id="idGerente" required>
          </div>
          <div class="form-group mb-4">
            <label for="dataInicio">Data de Início</label>
            <input type="date" class="form-control" id="dataInicio" name="dataInicio" required>
          </div>
          <div class="form-group mb-4">
            <label for="previsaoTermino">Previsão de Término</label>
            <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" required>
          </div>
          <div class="form-group mb-4">
            <label for="orcamentoTotal">Orçamento Total R$:</label>
            <input type="text" step="0.01" class="form-control" id="orcamento" name="orcamento" required>
          </div>
          <div class="form-group mb-4">
            <label for="descricao">Descrição</label>
            <textarea class="form-control" id="descricao" name="descricao" rows="3" required></textarea>
          </div>
          <div class="form-group mb-4">
            <label for="status">Status</label>
            <select class="form-control" id="status" name="status" required>
              <option selected>Selecione uma Opção</option>
              <option>EM_ANALISE</option>
              <option>ANALISE_REALIZADA</option>
              <option>INICIADO</option>
              <option>PLANEJADO</option>
              <option>EM_ANDAMENTO</option>
              <option>ENCERRADO</option>
              <option>CANCELADO</option>
            </select>
          </div>
          <div class="form-group mb-4">
            <label for="risco">Risco</label>
            <select class="form-control" id="risco" name="risco" required>
              <option selected>Selecione uma Opção</option>
              <option>BAIXO_RISCO</option>
              <option>MEDIO_RISCO</option>
              <option>ALTO_RISCO</option>
            </select>
          </div>
          <button type="button" class="btn btn-primary btn-custom" onclick="Cadastro()"><i class="bi bi-save"></i>
            Cadastrar</button>
        </form>
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