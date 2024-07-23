package personal.queiroz.felipe.desafioJava.dto;

import jakarta.validation.constraints.NotNull;

public record CadastroMembroDTO(
        @NotNull
        Long idProjeto,
        @NotNull
        Long idPessoa) {
}
