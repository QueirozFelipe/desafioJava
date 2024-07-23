package personal.queiroz.felipe.desafioJava.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record CadastroPessoaDTO(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataNascimento,
        @NotBlank @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos.")
        String cpf,
        @NotNull
        Boolean funcionario,
        @NotNull
        Boolean gerente

) {
}