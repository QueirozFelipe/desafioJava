function Reload() {
  document.location.reload(true);
}

function RecuperarDados(button) {
  const itemId = button.dataset.id;
  const url = `http://localhost:8080/projeto/${itemId}`;
  fetch(url)
    .then(response => response.json())
    .then(data => {
      document.getElementById('nome').value = data.nome;
      document.getElementById('dataInicio').value = data.dataInicio;
      document.getElementById('dataPrevisaoFim').value = data.dataPrevisaoFim;
      document.getElementById('orcamento').value = data.orcamento;
      document.getElementById('descricao').value = data.descricao;
      document.getElementById('status').value = data.status;
      document.getElementById('risco').value = data.risco;
      document.getElementById('idGerente').value = idGerente;
    })
    .catch(error => {
      console.error('Erro:', error);
    });

}

function AlterarDados(button) {
      const itemId = button.dataset.id;
      const urlEditar = `http://localhost:8080/projeto/${itemId}/atualizar`;
      const inputData = {
        nome: document.getElementById('nome').value,
        dataInicio: document.getElementById('dataInicio').value,
        gerente: document.getElementById('gerente').value,
        dataPrevisaoFim: document.getElementById('dataPrevisaoFim').value,
        orcamento: document.getElementById('orcamento').value,
        descricao: document.getElementById('descricao').value,
        status: document.getElementById('status').value,
        risco: document.getElementById('risco').value
      };

      fetch(urlEditar, {
            method: 'PUT',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(inputData)

          })
          .then(response => {
            if (response.ok) {
              location.reload();
            }
            return response.json()
          })
          .then(data => console.log(data))
          .catch(error => console.error(error))


      }

function Cadastro() {
  const urlCadastro = `http://localhost:8080/projeto/`;
  const inputData = {
    nome: document.getElementById('nome').value,
    idGerente: document.getElementById('idGerente').value,
    dataInicio: document.getElementById('dataInicio').value,
    dataPrevisaoFim: document.getElementById('dataPrevisaoFim').value,
    orcamento: document.getElementById('orcamento').value,
    descricao: document.getElementById('descricao').value,
    status: document.getElementById('status').value,
    risco: document.getElementById('risco').value
  };

  fetch(urlCadastro, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(inputData)

  })
    .then(response => {
      if (response.ok) {
        alert("Cadastro incluído com sucesso!");
        return response.json();
      } else {
        alert("Não foi possível incluir o cadastro. Verifique os dados.");
        return response.text().then(text => { throw new Error(text) });
      }
    })
    .then(data => {
      console.log(data);
      location.reload();
    })
    .catch(error => {
      console.error('Erro:', error.message);
    });
}

function deleteProjeto(button) {
  const itemId = button.dataset.id;
  const urldeletar = `http://localhost:8080/projeto/${itemId}/deletar`;
  fetch(urldeletar, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(response => {
      if (!response.ok) {
        alert('Projeto Já iniciado, em Andamento ou Encerrado! Verifique!')
      } else if (response.ok) {
        alert('Projeto removido com sucesso!')
      } location.reload();
      return response.json()
    })
    .then(data => console.log(data))
    .catch(error => console.error(error))

}



