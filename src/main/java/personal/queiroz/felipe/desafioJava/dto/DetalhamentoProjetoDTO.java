package personal.queiroz.felipe.desafioJava.dto;

import personal.queiroz.felipe.desafioJava.model.Pessoa;
import personal.queiroz.felipe.desafioJava.model.Projeto;
import personal.queiroz.felipe.desafioJava.model.Risco;
import personal.queiroz.felipe.desafioJava.model.Status;

import java.math.BigDecimal;
import java.time.LocalDate;



public record DetalhamentoProjetoDTO(Long id, String nome, LocalDate dataInicio, LocalDate dataPrevisaoFim, LocalDate dataFim,
                                     String descricao, Status status, Double orcamento, Risco risco, Long idGerente, String nomeGerente) {

    public DetalhamentoProjetoDTO(Projeto projeto) {
        this(projeto.getId(), projeto.getNome(), projeto.getDataInicio(), projeto.getDataPrevisaoFim(), projeto.getDataFim(), projeto.getDescricao(),
                projeto.getStatus(), projeto.getOrcamento(), projeto.getRisco(), projeto.getGerente().getId(), projeto.getGerente().getNome());
    }
}
