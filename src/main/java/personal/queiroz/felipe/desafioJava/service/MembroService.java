package personal.queiroz.felipe.desafioJava.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.queiroz.felipe.desafioJava.dto.CadastroMembroDTO;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoMembroDTO;
import personal.queiroz.felipe.desafioJava.repository.MembroRepository;
import personal.queiroz.felipe.desafioJava.model.Membro;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;
import personal.queiroz.felipe.desafioJava.repository.ProjetoRepository;
import java.util.List;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ProjetoRepository projetoRepository;


    @Transactional
    public Membro salvarMembro(CadastroMembroDTO dto) {
        var pessoa = pessoaRepository.findByIdAndFuncionarioTrue(dto.idPessoa());
        if(pessoa == null) throw new IllegalArgumentException("Pessoa não localizada ou não é funcionário!");
        var projeto = projetoRepository.getReferenceById(dto.idProjeto());
        var membroId = new Membro.MembroId(projeto, pessoa);
        return membroRepository.save(new Membro(membroId));
    }

    @Transactional
    public boolean deletarMembro(Long idProjeto, Long idPessoa) {
        if (membroRepository.existsByIdProjetoAndIdPessoa(idProjeto, idPessoa)) {
            membroRepository.deleteByIdProjetoAndIdPessoa(idProjeto, idPessoa);
            return true;
        }
        return false;
    }

    public List<DetalhamentoMembroDTO> listarMembrosPorProjeto(Long id) {
        return membroRepository.findByIdProjeto(id).stream().map(DetalhamentoMembroDTO::new).toList();
    }
}
