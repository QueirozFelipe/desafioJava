package personal.queiroz.felipe.desafioJava.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import personal.queiroz.felipe.desafioJava.dto.AtualizacaoPessoaDTO;
import personal.queiroz.felipe.desafioJava.dto.CadastroPessoaDTO;
import personal.queiroz.felipe.desafioJava.dto.DetalhamentoPessoaDTO;
import personal.queiroz.felipe.desafioJava.model.Pessoa;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;
import personal.queiroz.felipe.desafioJava.validation.CadastrarPessoaValidation;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class PessoaServiceTest {

    @Mock
    private PessoaRepository repository;

    @Mock
    private CadastrarPessoaValidation validador1;

    @Mock
    private CadastrarPessoaValidation validador2;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pessoaService.validadores = List.of(validador1, validador2);
    }

    @Test
    void salvarPessoa_DeveSalvarPessoaComSucesso() {
        CadastroPessoaDTO dto = mock(CadastroPessoaDTO.class);
        doNothing().when(validador1).validar(dto);
        doNothing().when(validador2).validar(dto);
        when(repository.save(any(Pessoa.class))).thenAnswer(i -> i.getArguments()[0]);

        Pessoa pessoaSalva = pessoaService.salvarPessoa(dto);

        assertNotNull(pessoaSalva);
        verify(validador1, times(1)).validar(dto);
        verify(validador2, times(1)).validar(dto);
        verify(repository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void listarPessoas_DeveRetornarListaDePessoas() {
        List<Pessoa> pessoas = List.of(new Pessoa(), new Pessoa());
        when(repository.findAll()).thenReturn(pessoas);

        List<DetalhamentoPessoaDTO> result = pessoaService.listarPessoas();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void detalharPessoa_DeveRetornarPessoaDetalhada() {
        Pessoa pessoa = new Pessoa();
        when(repository.findById(anyLong())).thenReturn(Optional.of(pessoa));

        DetalhamentoPessoaDTO result = pessoaService.detalharPessoa(1L);

        assertNotNull(result);
        verify(repository, times(1)).findById(anyLong());
    }

    @Test
    void detalharPessoa_DeveRetornarNullSeNaoEncontrarPessoa() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        DetalhamentoPessoaDTO result = pessoaService.detalharPessoa(1L);

        assertNull(result);
        verify(repository, times(1)).findById(anyLong());
    }

    @Test
    void atualizarPessoa_DeveAtualizarPessoaComSucesso() {
        AtualizacaoPessoaDTO dto = mock(AtualizacaoPessoaDTO.class);
        Pessoa pessoa = new Pessoa();
        when(repository.getReferenceById(anyLong())).thenReturn(pessoa);
        when(repository.save(any(Pessoa.class))).thenAnswer(i -> i.getArguments()[0]);

        DetalhamentoPessoaDTO result = pessoaService.atualizarPessoa(1L, dto);

        assertNotNull(result);
        verify(repository, times(1)).getReferenceById(anyLong());
        verify(repository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void deletarPessoa_DeveDeletarPessoaComSucesso() {
        when(repository.existsById(anyLong())).thenReturn(true);
        doNothing().when(repository).deleteById(anyLong());

        Boolean result = pessoaService.deletarPessoa(1L);

        assertTrue(result);
        verify(repository, times(1)).existsById(anyLong());
        verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void deletarPessoa_DeveRetornarFalseSeNaoEncontrarPessoa() {
        when(repository.existsById(anyLong())).thenReturn(false);

        Boolean result = pessoaService.deletarPessoa(1L);

        assertFalse(result);
        verify(repository, times(1)).existsById(anyLong());
        verify(repository, never()).deleteById(anyLong());
    }
}
