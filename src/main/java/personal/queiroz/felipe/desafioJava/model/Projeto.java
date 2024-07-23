package personal.queiroz.felipe.desafioJava.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;
import personal.queiroz.felipe.desafioJava.dto.CadastroProjetoDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "projeto")
@Entity(name = "Projeto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevisaoFim;
    @Column(name = "data_fim")
    private LocalDate dataFim;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Double orcamento;
    @Enumerated(EnumType.STRING)
    private Risco risco;
    @ManyToOne(fetch = FetchType.LAZY)
    @Nullable
    @JoinColumn(name = "idgerente" )
    private Pessoa gerente;

    public Projeto(CadastroProjetoDTO dto) {
        this.nome = dto.nome();
        this.dataInicio = dto.dataInicio();
        this.dataPrevisaoFim = dto.dataPrevisaoFim();
        this.descricao = dto.descricao();
        this.status = dto.status();
        this.orcamento = dto.orcamento();
        this.risco = dto.risco();
    }

}
