package personal.queiroz.felipe.desafioJava.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import personal.queiroz.felipe.desafioJava.model.Risco;
import personal.queiroz.felipe.desafioJava.model.Status;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastroProjetoDTO(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataInicio,
        @NotNull
        LocalDate dataPrevisaoFim,
        @NotBlank
        String descricao,
        @NotNull
        Status status,
        @NotNull
        Double orcamento,
        @NotNull
        Risco risco,
        @NotNull
        Long idGerente
)  {
}
