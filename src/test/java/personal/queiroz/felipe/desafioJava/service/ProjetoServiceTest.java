package personal.queiroz.felipe.desafioJava.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import personal.queiroz.felipe.desafioJava.dto.AtualizacaoProjetoDTO;
import personal.queiroz.felipe.desafioJava.dto.CadastroProjetoDTO;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoProjetoDTO;
import personal.queiroz.felipe.desafioJava.exception.BusinessRuleException;
import personal.queiroz.felipe.desafioJava.model.Pessoa;
import personal.queiroz.felipe.desafioJava.model.Projeto;
import personal.queiroz.felipe.desafioJava.model.Status;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;
import personal.queiroz.felipe.desafioJava.repository.ProjetoRepository;
import personal.queiroz.felipe.desafioJava.validation.CadastrarProjetoValidation;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private CadastrarProjetoValidation validador1;

    @Mock
    private CadastrarProjetoValidation validador2;

    @InjectMocks
    private ProjetoService projetoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        projetoService.setValidadores(List.of(validador1, validador2));
    }

    @Test
    void salvarProjeto_DeveSalvarProjetoComSucesso() {
        CadastroProjetoDTO dto = mock(CadastroProjetoDTO.class);
        doNothing().when(validador1).validar(dto);
        doNothing().when(validador2).validar(dto);
        when(projetoRepository.save(any(Projeto.class))).thenAnswer(i -> i.getArguments()[0]);
        when(pessoaRepository.getReferenceById(anyLong())).thenReturn(new Pessoa());

        Projeto projetoSalvo = projetoService.salvarProjeto(dto);

        assertNotNull(projetoSalvo);
        verify(validador1, times(1)).validar(dto);
        verify(validador2, times(1)).validar(dto);
        verify(projetoRepository, times(1)).save(any(Projeto.class));
    }

    @Test
    void detalharProjeto_DeveRetornarNuloSeProjetoNaoExistir() {
        when(projetoRepository.findById(anyLong())).thenReturn(Optional.empty());

        DetalhamentoProjetoDTO result = projetoService.detalharProjeto(1L);

        assertNull(result);
        verify(projetoRepository, times(1)).findById(anyLong());
    }

    @Test
    void atualizarProjeto_DeveAtualizarEretornarDetalhesDoProjeto() {
        Projeto projeto = new Projeto();
        AtualizacaoProjetoDTO dto = mock(AtualizacaoProjetoDTO.class);
        when(projetoRepository.getReferenceById(anyLong())).thenReturn(projeto);
        when(pessoaRepository.getReferenceById(anyLong())).thenReturn(new Pessoa());
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        DetalhamentoProjetoDTO result = projetoService.atualizarProjeto(1L, dto);

        assertNotNull(result);
        verify(projetoRepository, times(1)).getReferenceById(anyLong());
        verify(projetoRepository, times(1)).save(any(Projeto.class));
    }

    @Test
    void deletarProjeto_DeveRetornarTrueSeDeletadoComSucesso() {
        Projeto projeto = new Projeto();
        projeto.setStatus(Status.EM_ANALISE);
        when(projetoRepository.getReferenceById(anyLong())).thenReturn(projeto);
        when(projetoRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(projetoRepository).deleteById(anyLong());

        boolean result = projetoService.deletarProjeto(1L);

        assertTrue(result);
        verify(projetoRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void deletarProjeto_DeveLancarExcecaoSeStatusNaoPermitirCancelamento() {
        Projeto projeto = new Projeto();
        projeto.setStatus(Status.INICIADO);
        when(projetoRepository.getReferenceById(anyLong())).thenReturn(projeto);

        assertThrows(BusinessRuleException.class, () -> projetoService.deletarProjeto(1L));
    }
}

