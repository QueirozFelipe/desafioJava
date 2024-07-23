package personal.queiroz.felipe.desafioJava.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import personal.queiroz.felipe.desafioJava.dto.CadastroPessoaDTO;
import personal.queiroz.felipe.desafioJava.dto.CadastroProjetoDTO;
import personal.queiroz.felipe.desafioJava.model.Pessoa;
import personal.queiroz.felipe.desafioJava.model.Projeto;
import personal.queiroz.felipe.desafioJava.model.Risco;
import personal.queiroz.felipe.desafioJava.model.Status;
import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MembroRepositoryTest {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deve retornar false se projeto nao existe")
    void existsByIdProjetoAndIdPessoaCenario1() {
        var pessoa = cadastraPessoa();
        cadastraProjeto(pessoa);
        var membro = membroRepository.existsByIdProjetoAndIdPessoa(999l, pessoa.getId());
        assertThat(membro).isFalse();
    }

    @Test
    @DisplayName("Deve retornar false se pessoa nao existe")
    void existsByIdProjetoAndIdPessoaCenario2() {
        var pessoa = cadastraPessoa();
        var projeto = cadastraProjeto(pessoa);
        var membro = membroRepository.existsByIdProjetoAndIdPessoa(projeto.getId(), 999l);
        assertThat(membro).isFalse();
    }

    private Pessoa cadastraPessoa() {
        return em.persist(new Pessoa(cadastraPessoaDTO()));
    }

    private CadastroPessoaDTO cadastraPessoaDTO() {
        return new CadastroPessoaDTO("Nome", LocalDate.of(1990, 01, 01),
                "12312312312", true, true);
    }

    private Projeto cadastraProjeto(Pessoa pessoa) {
        var projeto = new Projeto(cadastraProjetoDTO(pessoa));
        projeto.setGerente(pessoaRepository.getReferenceById(pessoa.getId()));
        return em.persist(projeto);
    }

    private CadastroProjetoDTO cadastraProjetoDTO(Pessoa pessoa) {
        return new CadastroProjetoDTO("Projeto", LocalDate.of(2024,01,01), LocalDate.of(2024,01,01),
                "Descricao", Status.EM_ANALISE, 10.0, Risco.BAIXO_RISCO, pessoa.getId());
    }

}