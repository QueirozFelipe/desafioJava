package personal.queiroz.felipe.desafioJava.service;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.queiroz.felipe.desafioJava.dto.AtualizacaoProjetoDTO;
import personal.queiroz.felipe.desafioJava.dto.CadastroProjetoDTO;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoProjetoDTO;
import personal.queiroz.felipe.desafioJava.exception.BusinessRuleException;
import personal.queiroz.felipe.desafioJava.model.Projeto;
import personal.queiroz.felipe.desafioJava.model.Status;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;
import personal.queiroz.felipe.desafioJava.repository.ProjetoRepository;
import personal.queiroz.felipe.desafioJava.validation.CadastrarProjetoValidation;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Getter
@Setter
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private List<CadastrarProjetoValidation> validadores;

    @Transactional
    public Projeto salvarProjeto(CadastroProjetoDTO dto) {
        validadores.forEach(v -> v.validar(dto));
        var projeto = new Projeto(dto);
        if (projeto.getStatus() == Status.ENCERRADO) {
            projeto.setDataFim(LocalDate.now());
        }
        projeto.setGerente(pessoaRepository.getReferenceById(dto.idGerente()));
        return projetoRepository.save(projeto);
    }

    public List<DetalhamentoProjetoDTO> listarProjetos() {
        return projetoRepository.findAll().stream().map(DetalhamentoProjetoDTO::new).toList();
    }

    public DetalhamentoProjetoDTO detalharProjeto(Long id) {
        var projeto = projetoRepository.findById(id).orElse(null);
        if (Objects.isNull(projeto)) return null;
        return new DetalhamentoProjetoDTO(projeto);
    }

    public DetalhamentoProjetoDTO atualizarProjeto(Long id, AtualizacaoProjetoDTO dto) {
        var projeto = projetoRepository.getReferenceById(id);
        if (dto.nome() != null) {
            projeto.setNome(dto.nome());
        }
        if (dto.dataInicio() != null) {
            projeto.setDataInicio(dto.dataInicio());
        }
        if (dto.dataPrevisaoFim() != null) {
            projeto.setDataPrevisaoFim(dto.dataPrevisaoFim());
        }
        if (dto.descricao() != null) {
            projeto.setDescricao(dto.descricao());
        }
        if (dto.status() != null) {
            projeto.setStatus(dto.status());
        }
        if (dto.orcamento() != null) {
            projeto.setOrcamento(dto.orcamento());
        }
        if (dto.risco() != null) {
            projeto.setRisco(dto.risco());
        }
        if (dto.idGerente() != null) {
            projeto.setGerente(pessoaRepository.getReferenceById(dto.idGerente()));
        }
        if (projeto.getStatus() == Status.ENCERRADO) {
            projeto.setDataFim(LocalDate.now());
        }
        projetoRepository.save(projeto);
        return new DetalhamentoProjetoDTO(projeto);
    }

    @Transactional
    public boolean deletarProjeto(Long id) {
        if (projetoRepository.getReferenceById(id).getStatus() == Status.INICIADO
                || projetoRepository.getReferenceById(id).getStatus() == Status.EM_ANDAMENTO
                || projetoRepository.getReferenceById(id).getStatus() == Status.ENCERRADO) {
            throw new BusinessRuleException("O status atual do projeto não permite o cancelamento.");
        }
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
