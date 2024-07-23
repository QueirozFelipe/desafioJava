package personal.queiroz.felipe.desafioJava.model;

import jakarta.persistence.*;
import lombok.*;
import personal.queiroz.felipe.desafioJava.dto.CadastroPessoaDTO;

import java.time.LocalDate;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "datanascimento")
    private LocalDate dataNascimento;
    private String cpf;
    private Boolean funcionario;
    private Boolean gerente;

    public Pessoa(CadastroPessoaDTO pessoa) {
        this.nome = pessoa.nome();
        this.dataNascimento = pessoa.dataNascimento();
        this.cpf = pessoa.cpf();
        this.funcionario = pessoa.funcionario();
        this.gerente = pessoa.gerente();
    }

}
