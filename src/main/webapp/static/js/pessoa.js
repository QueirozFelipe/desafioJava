function Reload() {
  document.location.reload(true);
}

function RecuperarDados(button) {
  const itemId = button.dataset.id;
  const url = `http://localhost:8080/pessoa/${itemId}`;
  fetch(url)
    .then(response => response.json())
    .then(data => {
      document.getElementById('nome').value = data.nome;
      document.getElementById('dataNascimento').value = data.dataNascimento;
      document.getElementById('cpf').value = data.cpf;
      document.getElementById('funcionario').value = data.funcionario;
      document.getElementById('gerente').value = data.gerente;
    })
    .catch(error => {
      console.error('Erro:', error);
    });

}


function AlterarDados(button) {
      const itemId = button.dataset.id;
      const urlEditar = `http://localhost:8080/pessoa/${itemId}/atualizar`;
      const inputData = {
        nome: document.getElementById('nome').value,
        dataNascimento: document.getElementById('dataNascimento').value,
        cpf: document.getElementById('cpf').value,
        funcionario: document.getElementById('funcionario').checked,
        gerente: document.getElementById('gerente').checked
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
  const urlCadastro = `http://localhost:8080/pessoa/`;
  const inputData = {
    nome: document.getElementById('nome').value,
    dataNascimento: document.getElementById('dataNascimento').value,
    cpf: document.getElementById('cpf').value,
    funcionario: document.getElementById('funcionario').checked,
    gerente: document.getElementById('gerente').checked
  };

  // Imprime o JSON gerado no console
  console.log('JSON a ser enviado:', JSON.stringify(inputData));

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

function deletePessoa(button) {
  const itemId = button.dataset.id;
  const urldeletar = `http://localhost:8080/pessoa/${itemId}/deletar`;
  fetch(urldeletar, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(response => {
      if (!response.ok) {
        alert('Não foi possível excluir a pessoa!')
      } else if (response.ok) {
        alert('Pessoa excluída com sucesso!')
      } location.reload();
      return response.json()
    })
    .then(data => console.log(data))
    .catch(error => console.error(error))

}



