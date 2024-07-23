package personal.queiroz.felipe.desafioJava.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import personal.queiroz.felipe.desafioJava.repository.PessoaRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProjetoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PessoaRepository pessoaRepository;


    @Test
    @DisplayName("Deve retornar erro 404 se não achar projeto com o id")
    void deletarProjetoCenario1() throws Exception {
        var response = mvc.perform(delete("/projeto/99/deletar"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

}