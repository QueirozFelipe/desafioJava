package personal.queiroz.felipe.desafioJava.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import personal.queiroz.felipe.desafioJava.model.Risco;
import personal.queiroz.felipe.desafioJava.model.Status;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AtualizacaoProjetoDTO(
        String nome,
        LocalDate dataInicio,
        LocalDate dataPrevisaoFim,
        String descricao,
        Status status,
        Double orcamento,
        Risco risco,
        Long idGerente) {
}
