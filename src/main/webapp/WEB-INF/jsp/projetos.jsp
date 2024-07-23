<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <title>Gerenciador de Projetos</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
      <style>
        .table-responsive {
          overflow-x: auto;
        }

        .table th,
        .table td {
          text-align: center;
        }

        .jumbotron {
          background: #f8f9fa;
          border-radius: .3rem;
          padding: 2rem;
          box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        .modal-content {
          border-radius: .3rem;
        }

        .modal-header {
          border-bottom: none;
        }

        .modal-footer {
          border-top: none;
        }

        .btn-custom {
          display: flex;
          align-items: center;
          justify-content: center;
          font-size: 1rem;
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
          </ul>
        </div>
      </nav>

      <div class="container-fluid mt-4">
        <div class="jumbotron text-center">
          <h1 class="display-4">Gerenciador de Projetos</h1>
          <p class="lead">Visualize e gerencie seus projetos de forma eficiente.</p>
        </div>

        <div class="table-responsive">
          <table class="table table-striped">
            <thead class="thead-light">
              <tr>
                <th>ID</th>
                <th>Nome do Projeto</th>
                <th>Data de Início</th>
                <th>Gerente Responsável</th>
                <th>Previsão de Término</th>
                <th>Data Real de Término</th>
                <th>Orçamento Total</th>
                <th>Descrição</th>
                <th>Status</th>
                <th>Risco</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="projeto" items="${projetos}">
                <tr>
                  <td>${projeto.id}</td>
                  <td>${projeto.nome}</td>
                  <td>${projeto.dataInicio}</td>
                  <td>${projeto.gerente.nome}</td>
                  <td>${projeto.dataPrevisaoFim}</td>
                  <td>${projeto.dataFim}</td>
                  <td>${projeto.orcamento}</td>
                  <td>${projeto.descricao}</td>
                  <td>${projeto.status}</td>
                  <td>${projeto.risco}</td>
                  <td>
                    <div class="d-flex justify-content-center">
                      <!-- Botão Editar -->
                      <button type="button" data-id="${projeto.id}" onclick="RecuperarDados(this)"
                        class="btn btn-dark btn-custom mr-2" data-toggle="modal" data-target="#modalEditarProjeto">
                        <i class="bi bi-pencil"></i>
                        Editar
                      </button>
                      <!-- Botão Excluir -->
                      <button type="button" data-id="${projeto.id}" class="btn btn-danger btn-custom"
                        onclick="deleteProjeto(this)">
                        <i class="bi bi-trash"></i>
                        Excluir
                      </button>
                    </div>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>

        <!-- Modal Editar Projeto -->
        <div class="modal fade" id="modalEditarProjeto" tabindex="-1" role="dialog"
          aria-labelledby="modalEditarProjetoTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="modalEditarProjetoTitle">Editar Projeto</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <label for="nome">Nome do Projeto:</label>
                    <input type="text" class="form-control" id="nome" name="nome">
                  </div>
                  <div class="form-group col-md-6">
                    <label for="idGerente">ID Gerente Responsável:</label>
                    <input type="number" class="form-control" id="idGerente" name="idGerente">
                  </div>
                  <div class="form-group col-md-6">
                    <label for="dataInicio">Data de Início:</label>
                    <input type="date" class="form-control" id="dataInicio" name="dataInicio">
                  </div>
                  <div class="form-group col-md-6">
                    <label for="dataPrevisaoFim">Previsão de Término:</label>
                    <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim">
                  </div>
                  <div class="form-group col-md-12">
                    <label for="descricao">Descrição:</label>
                    <textarea class="form-control" id="descricao" name="descricao"></textarea>
                  </div>
                  <div class="form-group col-md-4">
                    <label for="orcamento">Orçamento Total:</label>
                    <input type="number" placeholder="R$" class="form-control" id="orcamento" name="orcamento">
                  </div>
                  <div class="form-group col-md-4">
                    <label for="risco">Risco:</label>
                    <select class="form-control" id="risco" name="risco">
                      <option value="BAIXO">Baixo Risco</option>
                      <option value="MEDIO">Médio Risco</option>
                      <option value="ALTO">Alto Risco</option>
                    </select>
                  </div>
                  <div class="form-group col-md-4">
                    <label for="status">Status:</label>
                    <select class="form-control" id="status" name="status">
                      <option value="ANALISE_APROVADA">Análise Aprovada</option>
                      <option value="ENCERRADO">Encerrado</option>
                      <option value="CANCELADO">Cancelado</option>
                      <option value="ANALISE_REALIZADA">Análise Realizada</option>
                      <option value="EM_ANALISE">Em Análise</option>
                      <option value="PLANEJADO">Planejado</option>
                      <option value="EM_ANDAMENTO">Em Andamento</option>
                      <option value="INICIADO">Iniciado</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" data-id="${projeto.id}" onclick="AlterarDados(this);" data-dismiss="modal"
                  class="btn btn-primary">Salvar</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
              </div>
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
      </div>
    </body>

    </html>