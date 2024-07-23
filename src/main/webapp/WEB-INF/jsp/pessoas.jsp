<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <title>Cadastro de Pessoas</title>
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
              <a class="nav-link" href="/cadastroPessoa"><i class="bi bi-plus-circle"></i> Nova Pessoa</a>
            </li>
          </ul>
        </div>
      </nav>

      <div class="container-fluid mt-4">
        <div class="jumbotron text-center">
          <h1 class="display-4">Cadastro de Pessoas</h1>
          <p class="lead">Visualize e gerencie as pessoas cadastradas.</p>
        </div>

        <div class="table-responsive">
          <table class="table table-striped">
            <thead class="thead-light">
              <tr>
                <th>ID</th>
                <th>Nome Completo</th>
                <th>Data de Nascimento</th>
                <th>CPF</th>
                <th>É Funcionário</th>
                <th>É Gerente</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="pessoa" items="${pessoas}">
                <tr>
                  <td>${pessoa.id}</td>
                  <td>${pessoa.nome}</td>
                  <td>${pessoa.dataNascimento}</td>
                  <td>${pessoa.cpf}</td>
                  <td><input type="checkbox" ${pessoa.funcionario ? 'checked' : '' } disabled></td>
                  <td><input type="checkbox" ${pessoa.gerente ? 'checked' : '' } disabled></td>
                  <td>
                    <div class="d-flex justify-content-center">
                      <!-- Botão Editar -->
                      <button type="button" data-id="${pessoa.id}" onclick="RecuperarDados(this)"
                        class="btn btn-dark btn-custom mr-2" data-toggle="modal" data-target="#modalEditarPessoa">
                        <i class="bi bi-pencil"></i>
                        Editar
                      </button>
                      <!-- Botão Excluir -->
                      <button type="button" data-id="${pessoa.id}" class="btn btn-danger btn-custom"
                        onclick="deletePessoa(this)">
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

        <!-- Modal Editar Pessoa -->
        <div class="modal fade" id="modalEditarPessoa" tabindex="-1" role="dialog"
          aria-labelledby="modalEditarPessoaTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="modalEditarPessoaTitle">Editar Cadastro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <div class="form-row">
                  <!-- Nome -->
                  <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input value='' type="text" class="form-control" id="nome" name="nome">
                  </div>
                  <!-- Data de Nascimento -->
                  <div class="form-group col-md-12">
                    <label for="dataNascimento">Data de Nascimento</label>
                    <input value='' type="date" class="form-control" id="dataNascimento" name="dataNascimento">
                  </div>
                  <!-- CPF -->
                  <div class="form-group col-md-12">
                    <label for="cpf">CPF</label>
                    <input value='' type="text" class="form-control" id="cpf" name="cpf">
                  </div>
                  <!-- Checkboxes na mesma linha -->
                  <div class="form-group col-md-12">
                    <div class="form-row">
                      <div class="col-md-6">
                        <div class="custom-control custom-checkbox">
                          <input type="checkbox" class="custom-control-input" id="funcionario" name="funcionario">
                          <label class="custom-control-label" for="funcionario">Funcionário</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="custom-control custom-checkbox">
                          <input type="checkbox" class="custom-control-input" id="gerente" name="gerente">
                          <label class="custom-control-label" for="gerente">Gerente</label>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" data-id="${pessoa.id}" onclick="AlterarDados(this);" data-dismiss="modal"
                  class="btn btn-primary">Salvar</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
              </div>
            </div>
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
      </div>
    </body>

    </html>