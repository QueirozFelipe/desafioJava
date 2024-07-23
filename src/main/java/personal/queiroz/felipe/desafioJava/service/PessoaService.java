package personal.queiroz.felipe.desafioJava.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.queiroz.felipe.desafioJava.model.Pessoa;
import personal.queiroz.felipe.desafioJava.dto.AtualizacaoPessoaDTO;
import personal.queiroz.felipe.desafioJava.dto.CadastroPessoaDTO;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoPessoaDTO;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;
import personal.queiroz.felipe.desafioJava.validation.CadastrarPessoaValidation;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    @Autowired
    List<CadastrarPessoaValidation> validadores;

    @Transactional
    public Pessoa salvarPessoa(CadastroPessoaDTO dto) {
        validadores.forEach(v -> v.validar(dto));
        var pessoa = new Pessoa(dto);
        return repository.save(pessoa);
    }

    public List<DetalhamentoPessoaDTO> listarPessoas() {
        return repository.findAll().stream().map(DetalhamentoPessoaDTO::new).toList();
    }

    public DetalhamentoPessoaDTO detalharPessoa(Long id) {
        var pessoa = repository.findById(id).orElse(null);
        if (pessoa == null) return null;
        return new DetalhamentoPessoaDTO(pessoa);
    }

    @Transactional
    public DetalhamentoPessoaDTO atualizarPessoa(Long id, AtualizacaoPessoaDTO dto) {
        var pessoa = repository.getReferenceById(id);
        if(dto.nome() != null) {
            pessoa.setNome(dto.nome());
        }
        if(dto.dataNascimento() != null) {
            pessoa.setDataNascimento(dto.dataNascimento());
        }
        if(dto.cpf() != null) {
            pessoa.setCpf(dto.cpf());
        }
        if(dto.funcionario() != null) {
            pessoa.setFuncionario(dto.funcionario());
        }
        if(dto.gerente() != null) {
            pessoa.setGerente(dto.gerente());
        }
        repository.save(pessoa);
        return new DetalhamentoPessoaDTO(pessoa);
    }

    @Transactional
    public Boolean deletarPessoa(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
