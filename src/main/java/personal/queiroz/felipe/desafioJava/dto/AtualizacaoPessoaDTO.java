package personal.queiroz.felipe.desafioJava.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record AtualizacaoPessoaDTO(
        String nome,
        LocalDate dataNascimento,
        @Pattern(regexp = "\\d{11}")
        String cpf,
        Boolean funcionario,
        Boolean gerente

) {
}